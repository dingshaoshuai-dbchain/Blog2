package cloud.dbchain.blog2

import cloud.dbchain.blog2.cache.UserCache
import cloud.dbchain.blog2.ui.login.LoginActivity
import dingshaoshuai.base.BaseActivity

class SplashActivity : BaseActivity() {
    override val layoutId: Int
        get() = 0

    override fun initContentView() {
        val value = UserCache.getValue()
        if (value == null) {
            LoginActivity.start(this)
        } else {
            MainActivity.start(this)
        }
        finish()
    }
}