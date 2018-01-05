package com.mindorks.framework.mvp.di.builder

import com.mindorks.framework.mvp.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by jyotidubey on 05/01/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity
}