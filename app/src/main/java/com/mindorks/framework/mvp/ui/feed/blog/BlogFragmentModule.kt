package com.mindorks.framework.mvp.ui.feed.blog

import android.support.v7.widget.LinearLayoutManager
import com.mindorks.framework.mvp.ui.feed.blog.interactor.BlogInteractor
import com.mindorks.framework.mvp.ui.feed.blog.interactor.BlogMVPInteractor
import com.mindorks.framework.mvp.ui.feed.blog.presenter.BlogMVPPresenter
import com.mindorks.framework.mvp.ui.feed.blog.presenter.BlogPresenter
import com.mindorks.framework.mvp.ui.feed.blog.view.BlogAdapter
import com.mindorks.framework.mvp.ui.feed.blog.view.BlogFragment
import com.mindorks.framework.mvp.ui.feed.blog.view.BlogMVPView
import dagger.Module
import dagger.Provides
import java.util.*

/**
 * Created by jyotidubey on 14/01/18.
 */
@Module
class BlogFragmentModule {

    @Provides
    internal fun provideBlogInteractor(interactor: BlogInteractor): BlogMVPInteractor = interactor

    @Provides
    internal fun provideBlogPresenter(presenter: BlogPresenter<BlogMVPView, BlogMVPInteractor>)
            : BlogMVPPresenter<BlogMVPView, BlogMVPInteractor> = presenter

    @Provides
    internal fun provideBlogAdapter(): BlogAdapter = BlogAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: BlogFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

}