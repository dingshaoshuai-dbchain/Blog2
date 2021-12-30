package cloud.dbchain.blog2

import cloud.dbchain.blog2.cache.UserCache
import dingshaoshuai.base.mvvm.BaseViewModel
import dingshaoshuai.base.mvvm.ObservableString

class MainViewModel : BaseViewModel() {
    val avatarCid = ObservableString(UserCache.getValue()?.photo)
}