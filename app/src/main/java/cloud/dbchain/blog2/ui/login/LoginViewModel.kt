package cloud.dbchain.blog2.ui.login

import android.text.TextUtils
import androidx.lifecycle.LiveData
import cloud.dbchain.blog2.R
import cloud.dbchain.blog2.cache.UserCache
import cloud.dbchain.blog2.repository.LoginRepository
import cloud.dbchain.blog2.util.checkPassword
import cloud.dbchain.blog2.util.isPhoneNumber
import cloud.dbchain.network.bean.UserBean
import dingshaoshuai.base.ktx.launchLoading
import dingshaoshuai.base.mvvm.BaseViewModel
import dingshaoshuai.base.mvvm.CallLiveData
import dingshaoshuai.base.mvvm.ObservableString
import dingshaoshuai.function.toast

/**
 * @author: Xiao Bo
 * @date: 25/8/2021
 */
class LoginViewModel : BaseViewModel() {
    val phoneNumber = ObservableString()
    val password = ObservableString()
    private val _startMainCallLiveData = CallLiveData()
    val startMainCallLiveData: LiveData<Void> = _startMainCallLiveData

    fun login() {
        val phoneNumberValue = phoneNumber.get()
        if (TextUtils.isEmpty(phoneNumberValue)) {
            // 手机号空
            toast(R.string.input_phone_number)
            return
        }
        if (!phoneNumberValue.isPhoneNumber()) {
            // 检查手机号码是否合规
            toast(R.string.input_valid_phone_number)
            return
        }
        val passwordValue = password.get()
        if (TextUtils.isEmpty(passwordValue)) {
            // 密码空
            toast(R.string.input_password)
            return
        }
        if (!passwordValue.checkPassword()) {
            // 校验密码是否合规
            toast(R.string.input_valid_format_password)
            return
        }
        // 请求登录
        launchLoading(
            blockIO = {
                LoginRepository().login(phoneNumberValue, passwordValue)
            },
            checkBlock = {
                it != null && it
            },
            successBlock = {
                toast(R.string.login_success)
                UserCache.setValue(UserBean(phoneNumberValue, passwordValue))
                _startMainCallLiveData.call()
            }
        )
    }
}