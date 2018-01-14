package com.mindorks.framework.mvp.di.builder

import com.mindorks.framework.mvp.ui.feed.blog.BlogFragmentProvider
import com.mindorks.framework.mvp.ui.feed.opensource.OpenSourceFragmentProvider
import com.mindorks.framework.mvp.ui.feed.view.FeedActivity
import com.mindorks.framework.mvp.ui.login.LoginActivityModule
import com.mindorks.framework.mvp.ui.login.view.LoginActivity
import com.mindorks.framework.mvp.ui.main.MainActivityModule
import com.mindorks.framework.mvp.ui.main.view.MainActivity
import com.mindorks.framework.mvp.ui.splash.SplashActivityModule
import com.mindorks.framework.mvp.ui.splash.view.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by jyotidubey on 05/01/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(SplashActivityModule::class))
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = arrayOf(BlogFragmentProvider::class, OpenSourceFragmentProvider::class))
    abstract fun bindFeedActivity(): FeedActivity
}