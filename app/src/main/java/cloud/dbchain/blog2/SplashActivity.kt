package cloud.dbchain.blog2

import cloud.dbchain.blog2.ui.login.RegisterActivity
import dingshaoshuai.base.BaseActivity

class SplashActivity : BaseActivity() {
    override val layoutId: Int
        get() = 0

    override fun initContentView() {
        RegisterActivity.start(this)
    }
}