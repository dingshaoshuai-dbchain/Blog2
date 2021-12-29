package cloud.dbchain.network

import android.app.Application
import dingshaoshuai.network.initNetworkLib
import okhttp3.Interceptor

/**
 * @author: Xiao Bo
 * @date: 28/8/2021
 */

internal lateinit var networkApplication: Application

fun initAppNetworkLib(
    application: Application,
    baseUrl: String,
    isDebug: Boolean = false,
    isDefaultLogInterceptor: Boolean = false,
    interceptors: List<Interceptor>? = null,
    connectTimeout: Long = 30L,
    writeTimeout: Long = 30L,
    readTimeout: Long = 30L,
    connectTimeoutDownload: Long = 30L,
    writeTimeoutDownload: Long = 30L,
    readTimeoutDownload: Long = 30L,
    logTagHttp: String = "app_http",
    logTagTest: String = "app_test",
    logTagError: String = "app_error",
) {
    networkApplication = application

    initNetworkLib(
        application,
        baseUrl,
        isDebug,
        isDefaultLogInterceptor,
        interceptors,
        connectTimeout,
        writeTimeout,
        readTimeout,
        connectTimeoutDownload,
        writeTimeoutDownload,
        readTimeoutDownload,
        logTagHttp,
        logTagTest,
        logTagError
    )
}