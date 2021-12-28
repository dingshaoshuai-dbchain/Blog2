package cloud.dbchain.blog2.network.interceptor

import android.os.Handler
import android.os.Looper
import cloud.dbchain.blog2.cache.UserCache
import cloud.dbchain.blog2.repository.LoginRepository
import cloud.dbchain.network.Code
import cloud.dbchain.network.bean.BaseResponse
import com.google.gson.Gson
import dingshaoshuai.function.toast
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.nio.charset.Charset

class CodeInterceptor : Interceptor {
    private val handle = Handler(Looper.getMainLooper())

    companion object {
        const val REFRESH_COOKIE = "refresh_cookie"

        @Volatile
        private var isCookieRefreshing = false

        @Volatile
        private var cookieRefreshResult = false
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var response = chain.proceed(chain.request())
        try {
            val string = getStringByResponseBody(response.body())
            val baseResponse = Gson().fromJson(string, BaseResponse::class.java)
            if (!Code.isSuccess(baseResponse)) {
                // 如果返回了错误为需要登录
                if (Code.isNotLogin(baseResponse.code)) {
                    // 涉及多线程问题，先检查是否正在刷新
                    if (!isCookieRefreshing) {
                        // 涉及多线程问题加锁
                        synchronized(REFRESH_COOKIE) {
                            isCookieRefreshing = true
                            val userBean = UserCache.getValue()
                            // 如果本地没有保存登录信息，直接设置 false
                            cookieRefreshResult = if (userBean != null) {
                                LoginRepository().login(userBean.userName, userBean.password)
                            } else {
                                false
                            }
                            isCookieRefreshing = false
                        }
                    }
                    // 1. 利用锁的机制来判断自动登录接口是否已经完成
                    synchronized(REFRESH_COOKIE) {

                    }
                    // 2. 循环检查自动登录接口是否已经完成
//                    while (isCookieRefreshing) {
//                        Thread.sleep(100)
//                    }
                    if (cookieRefreshResult) {
                        response = chain.proceed(chain.request())
                    } else {
                        // 重新登录失败了，需要将本地登录信息清除
                        handle.post {
                            UserCache.clear()
                        }
                    }
                } else {
                    handle.post {
                        toast(baseResponse.msg)
                    }
                }
            }
        } catch (e: Exception) {
            handle.post {
                toast(Code.getMsgByCode(Code.FAILURE))
            }
        } finally {
            return response
        }
    }

    // 解决 response.body 只能读取一次问题
    private fun getStringByResponseBody(body: ResponseBody?): String {
        body ?: return ""
        val source = body.source()
        source.request(Long.MAX_VALUE)
        val buffer = source.buffer
        return buffer.clone().readString(Charset.defaultCharset())
    }
}