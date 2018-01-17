package com.mindorks.framework.mvp.di.builder

import com.mindorks.framework.mvp.ui.about.AboutFragmentProvider
import com.mindorks.framework.mvp.ui.feed.blog.BlogFragmentProvider
import com.mindorks.framework.mvp.ui.feed.opensource.OpenSourceFragmentProvider
import com.mindorks.framework.mvp.ui.feed.view.FeedActivity
import com.mindorks.framework.mvp.ui.login.LoginActivityModule
import com.mindorks.framework.mvp.ui.login.view.LoginActivity
import com.mindorks.framework.mvp.ui.main.MainActivityModule
import com.mindorks.framework.mvp.ui.main.view.MainActivity
import com.mindorks.framework.mvp.ui.rate.RateUsDialogFragmentProvider
import com.mindorks.framework.mvp.ui.splash.SplashActivityModule
import com.mindorks.framework.mvp.ui.splash.view.SplashMVPActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by jyotidubey on 05/01/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashMVPActivity

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (RateUsDialogFragmentProvider::class), (AboutFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [(BlogFragmentProvider::class), (OpenSourceFragmentProvider::class)])
    abstract fun bindFeedActivity(): FeedActivity

}