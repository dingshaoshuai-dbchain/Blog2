package cloud.dbchain.blog2.ui.login

import android.text.TextUtils
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import cloud.dbchain.blog2.R
import cloud.dbchain.blog2.ktx.launchApp
import cloud.dbchain.blog2.repository.LoginRepository
import cloud.dbchain.blog2.util.checkPassword
import cloud.dbchain.blog2.util.isPhoneNumber
import cloud.dbchain.blog2.util.toastSuccess
import dingshaoshuai.base.mvvm.BaseViewModel
import dingshaoshuai.base.mvvm.CallLiveData
import dingshaoshuai.base.mvvm.ObservableString
import dingshaoshuai.function.toast

/**
 * @author: Xiao Bo
 * @date: 27/8/2021
 */
class RecoverWordResetViewModel : BaseViewModel() {

    val checkPhoneNumber = ObservableBoolean(false)
    val phoneNumber = object : ObservableField<String>("13823188079") {
        override fun set(value: String?) {
            super.set(value)
            // 如果当前状态一致，则不重新设置
            if (value.isPhoneNumber() == checkPhoneNumber.get()) return
            checkPhoneNumber.set(value.isPhoneNumber())
        }
    }
    val recoverWord = ObservableString("Aa111111")
    val newPassword = ObservableString("Aa111111")

    private val _loginCallLiveData = CallLiveData()
    val loginCallLiveData: LiveData<Void> = _loginCallLiveData

    fun reset() {
        val phoneNumberValue = phoneNumber.get()
        if (TextUtils.isEmpty(phoneNumberValue)) {
            toast(R.string.input_phone_number)
            return
        }
        if (!phoneNumberValue.isPhoneNumber()) {
            toast(R.string.input_valid_phone_number)
            return
        }
        val recoverWordValue = recoverWord.get()
        if (TextUtils.isEmpty(recoverWordValue)) {
            toast(R.string.input_phone_number)
            return
        }
        val newPasswordValue = newPassword.get()
        if (TextUtils.isEmpty(newPasswordValue)) {
            toast(R.string.input_password)
            return
        }
        if (!newPasswordValue.checkPassword()) {
            // 校验密码是否合规
            toast(R.string.input_valid_format_password)
            return
        }
        // 执行重置密码
        launchApp(
            blockIO = {
                LoginRepository().resetPasswordFromRecoverWord(phoneNumberValue!!, recoverWordValue, newPasswordValue)
            },
            successBlock = {
                toastSuccess()
                _loginCallLiveData.call()
                finishPage()
            },
        )
    }
}