package cloud.dbchain.blog2.network.interceptor

import android.text.TextUtils
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author: Xiao Bo
 * @date: 30/8/2021
 */
class CookieInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newBuilder = request.newBuilder()
        if (!TextUtils.isEmpty(cookie)) {
            newBuilder.addHeader("Cookie", cookie!!)
        }
        return chain.proceed(newBuilder.build())
    }

    companion object {
        var cookie: String? = null
    }
}