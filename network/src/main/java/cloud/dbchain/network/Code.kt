package cloud.dbchain.network

import android.text.TextUtils
import android.util.SparseArray
import cloud.dbchain.network.bean.BaseResponse

object Code {

    fun isSuccess(baseBean: BaseResponse<*>?): Boolean {
        return baseBean != null && isSuccess(baseBean.code)
    }

    fun isSuccessStrict(baseBean: BaseResponse<*>?): Boolean {
        return baseBean != null && isSuccess(baseBean.code) && baseBean.data != null
    }

    private fun isSuccess(code: Int) = code == SUCCESS
    fun isSuccess(result: String) = result == "Success"

    fun isNotLogin(code: Int) = code == NOT_LOGGED

    fun getMsgByCode(code: Int): String {
        val value = map.get(code)
        if (TextUtils.isEmpty(value)) {
            return networkApplication.getString(R.string.network_error)
        }
        return value
    }

    private val map = SparseArray<String>().apply {
        put(SUCCESS, networkApplication.getString(R.string.success))
        put(FAILURE, networkApplication.getString(R.string.failure))
        put(NOT_LOGGED, networkApplication.getString(R.string.not_logged))
    }

    // 成功
    const val SUCCESS = 0

    // 失败
    const val FAILURE = 1

    // 未登录，请先登录
    const val NOT_LOGGED = 2
}