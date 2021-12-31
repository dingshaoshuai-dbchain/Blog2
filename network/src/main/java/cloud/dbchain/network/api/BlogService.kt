package cloud.dbchain.network.api

import cloud.dbchain.network.bean.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface BlogService {

    @POST("blog/getBlogs")
    suspend fun getBlogs(@Body map: Map<String, String>): BaseResponse<List<Any>>
}