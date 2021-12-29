package cloud.dbchain.blog2.ui.login

import android.content.Context
import android.content.Intent
import cloud.dbchain.blog2.MainActivity
import cloud.dbchain.blog2.R
import cloud.dbchain.blog2.binding.bindingLabelFocus
import cloud.dbchain.blog2.databinding.ActivityLoginBinding
import dingshaoshuai.base.ktx.defaultViewModel
import dingshaoshuai.base.mvvm.BaseMvvmActivity

class LoginActivity : BaseMvvmActivity<ActivityLoginBinding, LoginViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_login

    override fun bindViewModel(viewModel: LoginViewModel) {
        binding.viewModel = viewModel
    }

    override fun initViewModel(): LoginViewModel {
        return defaultViewModel()
    }

    override fun initClickListener() {
        super.initClickListener()
        bindingLabelFocus(binding.etPhoneNumber, binding.tvPhoneNumberTitle)
        bindingLabelFocus(binding.etPassword, binding.tvPasswordTitle)
        binding.tvRegister.setOnClickListener {
            RegisterActivity.start(this@LoginActivity)
        }
        binding.tvForgetPassword.setOnClickListener {
            //ResetPasswordActivity.start(this@LoginActivity)
        }
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.startMainCallLiveData.observe(this) {
            MainActivity.start(this)
            finish()
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent().apply {
                setClass(context, LoginActivity::class.java)
                // 携带参数
            }
            context.startActivity(intent)
        }
    }
}