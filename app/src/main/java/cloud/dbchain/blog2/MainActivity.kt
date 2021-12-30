package cloud.dbchain.blog2

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import cloud.dbchain.base.MApplication
import cloud.dbchain.blog2.cache.UserCache
import cloud.dbchain.blog2.databinding.ActivityMainBinding
import cloud.dbchain.blog2.ui.bloglist.AdapterFragmentPager
import cloud.dbchain.blog2.ui.bloglist.BlogListFragment
import com.google.android.material.tabs.TabLayout
import dingshaoshuai.base.mvvm.BaseMvvmActivity

class MainActivity : BaseMvvmActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initViewModel(): MainViewModel = MainViewModel()

    override fun bindViewModel(viewModel: MainViewModel) {
        binding.viewModel = viewModel
        binding.listener = MainActivityClick()
    }

    private val tableNameArray =
        MApplication.context.resources.getStringArray(R.array.table_list)
    private val fragmentList = mutableListOf<Fragment>().apply {
        add(BlogListFragment.newInstance())
        // 仅供示例，最新与评价最多，排序逻辑就不写了
        add(BlogListFragment.newInstance())
        add(BlogListFragment.newInstance())
    }

    override fun initContentView() {
        super.initContentView()
        initTableLayout()
        initViewPager()
    }

    override fun initObserver() {
        super.initObserver()
        UserCache.observer(this) {
            viewModel.avatarCid.set(it.photo)
        }
    }

    private fun initTableLayout() {
        tableNameArray.forEach {
            val view = View.inflate(this, R.layout.table, null).apply {
                if (this is AppCompatTextView) {
                    text = it
                }
            }
            val tab = binding.tableLayout.newTab().setCustomView(view)
            binding.tableLayout.addTab(tab)
        }
        binding.tableLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                selected(true, tab)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                selected(false, tab)
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                selected(true, tab)
                binding.viewPager.currentItem = tab?.position ?: 0
            }

            private fun selected(selected: Boolean, tab: TabLayout.Tab?) {
                tab?.let {
                    val customView = it.customView
                    if (customView is AppCompatTextView) {
                        if (selected) {
                            customView.textSize = 24F
                            customView.paint.isFakeBoldText = true
                        } else {
                            customView.textSize = 20F
                            customView.paint.isFakeBoldText = false
                        }
                    }
                }
            }
        })
        binding.tableLayout.getTabAt(0)?.select()
    }

    private fun initViewPager() {
        binding.viewPager.adapter = AdapterFragmentPager(this, fragmentList)
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tableLayout.getTabAt(position)?.select()
            }
        })
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent().apply {
                setClass(context, MainActivity::class.java)
                // 携带参数
            }
            context.startActivity(intent)
        }
    }

    inner class MainActivityClick {
        fun writeClick() {
            //EditActivity.start(this@MainActivity)
        }

        fun avatarClick() {
            //UserMainActivity.start(this@MainActivity)
        }
    }


}