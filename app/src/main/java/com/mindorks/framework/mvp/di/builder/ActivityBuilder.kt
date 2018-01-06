package com.mindorks.framework.mvp.di.builder

import com.mindorks.framework.mvp.ui.main.MainActivityModule
import com.mindorks.framework.mvp.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by jyotidubey on 05/01/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}