package cloud.dbchain.blog2.ui.login

import android.content.Context
import android.content.Intent
import android.widget.Toast
import cloud.dbchain.blog2.R
import cloud.dbchain.blog2.binding.bindingLabelFocus
import cloud.dbchain.blog2.databinding.ActivityRecoverResetBinding
import dingshaoshuai.base.ktx.defaultViewModel
import dingshaoshuai.base.mvvm.BaseMvvmActivity
import dingshaoshuai.function.toast

class RecoverWordResetActivity : BaseMvvmActivity<ActivityRecoverResetBinding, RecoverWordResetViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_recover_reset

    override fun bindViewModel(viewModel: RecoverWordResetViewModel) {
        binding.viewModel = viewModel
    }

    override fun initViewModel(): RecoverWordResetViewModel {
        return defaultViewModel()
    }

    override fun initClickListener() {
        super.initClickListener()
        bindingLabelFocus(binding.etPhoneNumber, binding.tvPhoneNumberTitle)
        bindingLabelFocus(binding.etRecoverWord, binding.tvRecoverWordTitle)
        bindingLabelFocus(binding.etPassword, binding.tvPasswordTitle)
        binding.ivSetPasswordPrompt.setOnClickListener {
            toast(R.string.input_valid_format_password, Toast.LENGTH_LONG)
        }
        binding.tvLogin.setOnClickListener {
            LoginActivity.start(this@RecoverWordResetActivity)
        }
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.loginCallLiveData.observe(this) {
            LoginActivity.start(this)
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent().apply {
                setClass(context, RecoverWordResetActivity::class.java)
                // 携带参数
            }
            context.startActivity(intent)
        }
    }
}