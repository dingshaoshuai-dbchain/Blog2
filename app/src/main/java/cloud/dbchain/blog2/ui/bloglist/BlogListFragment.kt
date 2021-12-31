package cloud.dbchain.blog2.ui.bloglist

import android.graphics.Color
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cloud.dbchain.blog2.R
import cloud.dbchain.blog2.databinding.FragmentBloglistBinding
import cloud.dbchain.view.LinearSpacesItemDecoration
import com.qmuiteam.qmui.kotlin.dip
import dingshaoshuai.base.ktx.defaultViewModel
import dingshaoshuai.base.mvvm.BaseDataBindingAdapter
import dingshaoshuai.base.mvvm.BaseMvvmFragment

/**
 * @author: Xiao Bo
 * @date: 10/6/2021
 */
class BlogListFragment : BaseMvvmFragment<FragmentBloglistBinding, BlogListViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_bloglist

    private val adapter = BlogListAdapter()

    override fun initView(view: View) {
        binding.swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#2E44FF"))
        binding.rvBlog.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.addItemDecoration(
                LinearSpacesItemDecoration(
                    left = dip(16),
                    right = dip(16),
                    space = dip(12),
                    lastBottom = dip(150)
                )
            )
            it.adapter = this.adapter
        }
    }

    override fun initViewModel(): BlogListViewModel {
        return defaultViewModel()
    }

    override fun bindViewModel(viewModel: BlogListViewModel) {
        binding.viewModel = viewModel
    }

    override fun initClickListener(view: View) {
        super.initClickListener(view)
        adapter.itemClickListener = object : BaseDataBindingAdapter.ItemClickListener<Any> {
            override fun onItemClick(data: Any) {
                mActivity?.let { activity ->
                    //BlogDetailActivity.start(activity, data)
                }
            }
        }
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.blogListLiveData.observe(this, Observer {
            adapter.dataList = it
        })
    }

    override fun initData() {
        super.initData()
        viewModel.initData()
    }

    companion object {
        fun newInstance(): BlogListFragment {
            return BlogListFragment()
        }
    }
}