package cloud.dbchain.blog2.ui.login

import android.content.Context
import android.content.Intent
import android.widget.Toast
import cloud.dbchain.blog2.R
import cloud.dbchain.blog2.binding.bindingLabelFocus
import cloud.dbchain.blog2.databinding.ActivityRegisterBinding
import dingshaoshuai.base.ktx.defaultViewModel
import dingshaoshuai.base.mvvm.BaseMvvmActivity
import dingshaoshuai.function.toast

class RegisterActivity : BaseMvvmActivity<ActivityRegisterBinding, RegisterViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_register

    override fun bindViewModel(viewModel: RegisterViewModel) {
        binding.viewModel = viewModel
    }

    override fun initViewModel(): RegisterViewModel {
        return defaultViewModel()
    }

    override fun initClickListener() {
        super.initClickListener()
        bindingLabelFocus(binding.etPhoneNumber, binding.tvPhoneNumberTitle)
        bindingLabelFocus(binding.etPassword, binding.tvPasswordTitle)
        bindingLabelFocus(binding.etPasswordConfirm, binding.tvPasswordConfirmTitle)
        binding.ivSetPasswordPrompt.setOnClickListener {
            toast(R.string.input_valid_format_password, Toast.LENGTH_LONG)
        }
        binding.tvLogin.setOnClickListener {
            //LoginActivity.start(this@RegisterActivity)
        }
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.loginCallLiveData.observe(this) {
            //LoginActivity.start(this)
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent().apply {
                setClass(context, RegisterActivity::class.java)
                // 携带参数
            }
            context.startActivity(intent)
        }
    }
}