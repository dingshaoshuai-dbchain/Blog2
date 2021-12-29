package cloud.dbchain.network.api

import cloud.dbchain.network.bean.BaseResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("user/register")
    suspend fun register(@Body map: Map<String, String>): BaseResponse<*>

    @POST("user/login")
    fun login(@Body map: Map<String, String>): Call<BaseResponse<Any>>

    @POST("user/resetPasswordFromRecoverWord")
    suspend fun resetPasswordFromRecoverWord(@Body map: Map<String, String>): BaseResponse<*>
}