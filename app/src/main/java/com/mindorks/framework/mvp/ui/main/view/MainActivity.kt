package com.mindorks.framework.mvp.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.about.view.AboutFragment
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.feed.view.FeedActivity
import com.mindorks.framework.mvp.ui.login.view.LoginActivity
import com.mindorks.framework.mvp.ui.main.interactor.MainInteractor
import com.mindorks.framework.mvp.ui.main.interactor.QuestionCardData
import com.mindorks.framework.mvp.ui.main.presenter.MainPresenter
import com.mindorks.framework.mvp.util.ScreenUtils
import com.mindorks.placeholderview.SwipeDecor
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.nav_header_navigation.view.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    internal lateinit var presenter: MainPresenter<MainView, MainInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpDrawerMenu()
        setupCardContainerView()
        presenter.onAttach(this)

    }

    override fun onFragmentDetached(tag: String) {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow()
            unlockDrawer()
        }
    }

    override fun onFragmentAttached() {
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        }

        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(AboutFragment.TAG)
        if (fragment == null) {
            super.onBackPressed()
        } else {
            onFragmentDetached(AboutFragment.TAG)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_about -> {
                presenter.onDrawerOptionAboutClick()
            }
            R.id.nav_item_rate_us -> {
                presenter.onDrawerOptionRateUsClick()
            }
            R.id.nav_item_feed -> {
                presenter.onDrawerOptionFeedClick()
            }
            R.id.nav_item_logout -> {
                presenter.onDrawerOptionLogoutClick()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun lockDrawer() {
        drawer_layout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    override fun unlockDrawer() {
        drawer_layout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    override fun displayQuestionCard(questionCards: List<QuestionCardData>) {
        for (questionCard in questionCards) {
            questionHolder.addView(QuestionCard(questionCard))
        }
    }

    override fun inflateUserDetails(userDetails: Pair<String?, String?>) {
        nav_view.getHeaderView(0).nav_name.text = userDetails.first
        nav_view.getHeaderView(0).nav_email.text = userDetails.second

    }

    override fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openAboutFragment() {
        lockDrawer()
        supportFragmentManager.beginTransaction().disallowAddToBackStack().setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .add(R.id.cl_root_view, AboutFragment.newInstance(), AboutFragment.TAG)
                .commit()
    }

    override fun openFeedActivity() {
        val intent = Intent(this, FeedActivity::class.java)
        startActivity(intent)
    }

    private fun setUpDrawerMenu() {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

    }

    private fun setupCardContainerView() {
        val screenWidth = ScreenUtils.getScreenWidth(this)
        val screenHeight = ScreenUtils.getScreenHeight(this)
        questionHolder.getBuilder()
                .setDisplayViewCount(3)
                .setHeightSwipeDistFactor(10f)
                .setWidthSwipeDistFactor(5f)
                .setSwipeDecor(SwipeDecor()
                        .setViewWidth((0.90 * screenWidth).toInt())
                        .setViewHeight((0.75 * screenHeight).toInt())
                        .setPaddingTop(20)
                        .setSwipeRotationAngle(10)
                        .setRelativeScale(0.01f))

        questionHolder.addItemRemoveListener { count ->
            if (count == 0) {
                Handler(mainLooper).postDelayed({ presenter.refreshQuestionCards() }, 800)
            }
        }
    }
}
