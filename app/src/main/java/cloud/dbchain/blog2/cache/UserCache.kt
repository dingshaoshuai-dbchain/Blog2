package cloud.dbchain.blog2.cache

import cloud.dbchain.blog2.network.interceptor.CookieInterceptor
import cloud.dbchain.network.bean.UserBean
import dingshaoshuai.function.cache.BaseAnyCache
import dingshaoshuai.function.kt.toObject

/**
 * @author: Xiao Bo
 * @date: 30/8/2021
 */
object UserCache : BaseAnyCache<UserBean>() {
    override val key: String
        get() = "nft_user_info"

    override fun json2any(valueJson: String): UserBean {
        return valueJson.toObject(UserBean::class.java)
    }

    override fun getValue(): UserBean? {
       return super.getValue()?.also {
            CookieInterceptor.cookie = it.cookie
        }
    }
}