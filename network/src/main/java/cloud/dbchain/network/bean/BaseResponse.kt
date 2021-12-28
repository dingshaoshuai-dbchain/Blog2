package cloud.dbchain.network.bean

import java.io.Serializable

/**
 * @author: Xiao Bo
 * @date: 30/8/2021
 */
data class BaseResponse<T>(
    val code: Int = 1,
    val msg: String = "",
    val data: T? = null
): Serializable