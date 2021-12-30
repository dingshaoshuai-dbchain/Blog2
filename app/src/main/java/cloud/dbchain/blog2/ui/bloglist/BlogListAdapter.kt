package cloud.dbchain.blog2.ui.bloglist

import cloud.dbchain.blog2.R
import cloud.dbchain.blog2.databinding.ItemBlogBinding
import dingshaoshuai.base.mvvm.BaseDataBindingAdapter

/**
 * @author: Xiao Bo
 * @date: 10/6/2021
 */
class BlogListAdapter : BaseDataBindingAdapter<String, ItemBlogBinding>() {

    override val layoutId: Int
        get() = R.layout.item_blog

    override fun onBind(binding: ItemBlogBinding, data: String, position: Int) {
        binding.itemClickListener = itemClickListener
    }
}