package cloud.dbchain.blog2

import cloud.dbchain.base.MApplication
import dingshaoshuai.network.BuildConfig
import dingshaoshuai.network.initNetworkLib

class BaseApplication : MApplication() {

    override fun onCreate() {
        super.onCreate()
        initNetworkLib(
            application = this,
            baseUrl = "http://localhost:8080",
            isDebug = BuildConfig.DEBUG,
            isDefaultLogInterceptor = true,
        )
    }
}