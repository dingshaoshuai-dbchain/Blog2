package cloud.dbchain.blog2

import cloud.dbchain.base.MApplication
import cloud.dbchain.blog2.network.interceptor.CodeInterceptor
import cloud.dbchain.blog2.network.interceptor.CookieInterceptor
import cloud.dbchain.network.initAppNetworkLib

class BaseApplication : MApplication() {

    override fun onCreate() {
        super.onCreate()
        initAppNetworkLib(
            application = this,
            baseUrl = "http://192.168.0.26:8080/",
            isDebug = BuildConfig.DEBUG,
            isDefaultLogInterceptor = true,
            interceptors = listOf(
                CodeInterceptor(),
                CookieInterceptor()
            )
        )
    }
}