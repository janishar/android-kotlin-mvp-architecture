package com.mindorks.framework.mvp.ui.feed.blog

import com.mindorks.framework.mvp.ui.feed.blog.view.BlogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by jyotidubey on 14/01/18.
 */
@Module
internal abstract class BlogFragmentProvider {

    @ContributesAndroidInjector(modules = [BlogFragmentModule::class])
    internal abstract fun provideBlogFragmentFactory(): BlogFragment
}