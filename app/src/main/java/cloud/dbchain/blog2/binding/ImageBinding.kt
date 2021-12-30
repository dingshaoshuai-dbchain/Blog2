package cloud.dbchain.blog2.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import cloud.dbchain.blog2.R
import cloud.dbchain.network.api.IPFS_URL
import dingshaoshuai.base.feature.image.ImageLoaderProxy

/**
 * @author: Xiao Bo
 * @date: 15/6/2021
 */

@BindingAdapter("binding:cid")
fun setImage(imageView: ImageView, cid: String) {
    ImageLoaderProxy.instance.load(imageView, IPFS_URL + cid, 0)
}

@BindingAdapter("binding:isMan")
fun setSex(imageView: ImageView, isMan: Boolean) {
    ImageLoaderProxy.instance.load(
        imageView,
        if (isMan) R.drawable.ic_sex_man else R.drawable.ic_sex_woman
    )
}