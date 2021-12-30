package cloud.dbchain.blog2.repository

import cloud.dbchain.network.bean.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object BlogRepository {

    suspend fun getBlogs(): BaseResponse<List<String>>? {
        return withContext(Dispatchers.IO) {
            BaseResponse(0, "", null)
        }
    }
}