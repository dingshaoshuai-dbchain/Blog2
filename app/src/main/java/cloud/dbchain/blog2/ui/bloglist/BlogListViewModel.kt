package cloud.dbchain.blog2.ui.bloglist

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cloud.dbchain.blog2.ktx.launchAppPageSwitch
import cloud.dbchain.blog2.repository.BlogRepository
import cloud.dbchain.network.Code
import dingshaoshuai.baseext.mvvm.BasePageViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BlogListViewModel : BasePageViewModel() {
    private val _blogListLiveData = MutableLiveData<List<Any>>()
    val blogListLiveData: LiveData<List<Any>> = _blogListLiveData

    val refreshing = ObservableBoolean()

    fun onRefresh() {
        viewModelScope.launch(Dispatchers.Main) {
            refreshing.set(true)
            val response = getBlogs()
            if (Code.isSuccess(response)) {
                val data = response?.data
                if (data == null || data.isEmpty()) {
                    showEmptyPage()
                } else {
                    _blogListLiveData.value = response.data
                }
            } else {
                showErrorPage()
            }

            refreshing.set(false)
        }
    }

    fun initData() {
        launchAppPageSwitch(
            blockIO = { getBlogs() },
            checkEmptyBlock = { it?.data?.isEmpty() ?: true },
            successBlock = { _blogListLiveData.value = it?.data }
        )
    }

    private suspend fun getBlogs() = BlogRepository.getBlogs(mapOf())
}