package cloud.dbchain.blog2.repository

import cloud.dbchain.network.api.BlogService
import cloud.dbchain.network.bean.BaseResponse
import dingshaoshuai.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object BlogRepository {

    suspend fun getBlogs(map: Map<String, String>): BaseResponse<List<Any>>? {
        return withContext(Dispatchers.IO) {
            RetrofitClient.sendRequestForReturn {
                RetrofitClient.createService(BlogService::class.java).getBlogs(map)
            }
        }
    }
}