package dingshaoshuai.buildsrc

object Libs {

    object DingShaoshuai {
        // BaseActivity、BaseMvvmActivity..
        const val base = "com.github.dingshaoshuai888:base-sample:1.1.1"

        // 状态页：加载页、空页面、网络错误页
        const val baseExt = "com.github.dingshaoshuai888:base-ext:1.1.1"

        // 常用的函数：Json 解析、图片加载、缓存...
        const val commonFunction = "com.github.dingshaoshuai888:common-function:1.1.2"

        // 网络
        const val network = "com.github.dingshaoshuai888:dingshaoshuai-network:v1.0.1"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val activityKtx = "androidx.activity:activity-ktx:1.2.2"

        object Lifecycle {
            private const val version = "2.3.1"
            const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Navigation {
            private const val version = "2.3.5"
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            const val runKtx = "androidx.navigation:navigation-runtime-ktx:$version"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }
    }

    object Google {
        object UI {
            const val material = "com.google.android.material:material:1.3.0"
        }
    }

    object Kotlin{
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"
    }

    object Code {
        // 二维码扫描
        const val zxing = "cn.yipianfengye.android:zxing-library:2.2"
        const val zxingYuZhiqiang = "com.github.yuzhiqiang1993:zxing:2.2.9"
        // 权限请求框架
        const val permissionX = "com.guolindev.permissionx:permissionx:1.5.1"

        object NetWork{

            object Retrofit{
                private const val version = "2.9.0"
                const val retrofit2 = "com.squareup.retrofit2:retrofit:$version"
                const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
            }
        }

        object UI {
            // 轮播图
            const val zhpanVipBannerViewPager = "com.github.zhpanvip:bannerviewpager:3.5.4"
            const val zhpanvipViewpagerindicator = "com.github.zhpanvip:viewpagerindicator:1.2.1"

            // 腾讯的 UI 框架
            const val qmui = "com.qmuiteam:qmui:2.0.0-alpha10"

            // 标签切换样式
            const val magicIndicator = "com.github.hackware1993:MagicIndicator:1.7.0"

            // 沉浸式状态栏等等
            const val immersionBar = "com.gyf.immersionbar:immersionbar:2.3.3"

            // 动画
            const val libpag = "com.tencent.tav:libpag:3.2.5.1"

            // 下拉刷新、上拉加载
            private const val refreshLayoutVersion = "2.0.3"
            // 核心必须依赖
            const val refreshLayoutKernel = "com.scwang.smart:refresh-layout-kernel:$refreshLayoutVersion"
            // 静态刷新头
            const val refreshHeaderClassics = "com.scwang.smart:refresh-header-classics:$refreshLayoutVersion"

            // 放大的 ImageView
            const val photoView = "com.github.chrisbanes:PhotoView:2.0.0"

            // 日期时间三级联动选择器
            const val pickerView = "com.contrarywind:Android-PickerView:4.1.9"

            const val permissionX = "com.guolindev.permissionx:permissionx:1.6.1"
        }


    }

}
