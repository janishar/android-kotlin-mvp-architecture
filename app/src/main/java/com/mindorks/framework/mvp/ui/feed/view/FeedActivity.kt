package com.mindorks.framework.mvp.ui.feed.view

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.feed.FeedPagerAdapter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_feed.*
import javax.inject.Inject

/**
 * Created by jyotidubey on 13/01/18.
 */
class FeedActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>


    internal lateinit var feedPagerAdapter: FeedPagerAdapter

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        feedPagerAdapter = FeedPagerAdapter(supportFragmentManager)
        setUpFeedPagerAdapter()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    private fun setUpFeedPagerAdapter() {
        feedPagerAdapter.count = 2
        feed_view_pager.adapter = feedPagerAdapter
        tab_layout.addTab(tab_layout.newTab().setText(R.string.blogs))
        tab_layout.addTab(tab_layout.newTab().setText(R.string.open_source))

        feed_view_pager.offscreenPageLimit = tab_layout.tabCount;

        feed_view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout));

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                feed_view_pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })


    }
}