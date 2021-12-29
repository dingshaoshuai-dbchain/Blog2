package cloud.dbchain.blog2.repository

import cloud.dbchain.blog2.network.interceptor.CookieInterceptor
import cloud.dbchain.network.Code
import cloud.dbchain.network.api.LoginService
import cloud.dbchain.network.bean.BaseResponse
import dingshaoshuai.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepository {
    suspend fun register(
        userName: String,
        password: String,
    ): BaseResponse<*>? {
        return withContext(Dispatchers.IO) {
            RetrofitClient.sendRequestForReturn {
                val map = mapOf(
                    "userName" to userName,
                    "password" to password,
                )
                return@sendRequestForReturn RetrofitClient.createService(LoginService::class.java)
                    .register(map)
            }
        }
    }

    fun login(
        userName: String,
        password: String,
    ): Boolean {
        CookieInterceptor.cookie = null
        val response = RetrofitClient.sendRequestForReturn {
            val map = mapOf(
                "userName" to userName,
                "password" to password
            )
            return@sendRequestForReturn RetrofitClient.createService(LoginService::class.java)
                .login(map).execute()
        } ?: return false
        CookieInterceptor.cookie = response.headers().get("set-cookie")
        return Code.isSuccess(response.body())
    }

    suspend fun resetPasswordFromRecoverWord(
        userName: String,
        recoverWord: String,
        newPassword: String,
    ): BaseResponse<*>? {
        return withContext(Dispatchers.IO) {
            RetrofitClient.sendRequestForReturn {
                val map = mapOf(
                    "userName" to userName,
                    "recoverWord" to recoverWord,
                    "newPassword" to newPassword,
                )
                return@sendRequestForReturn RetrofitClient.createService(LoginService::class.java)
                    .resetPasswordFromRecoverWord(map)
            }
        }
    }
}