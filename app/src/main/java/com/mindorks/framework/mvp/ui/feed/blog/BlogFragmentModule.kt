package com.mindorks.framework.mvp.ui.feed.blog

import android.support.v7.widget.LinearLayoutManager
import com.mindorks.framework.mvp.ui.feed.blog.interactor.BlogInteractor
import com.mindorks.framework.mvp.ui.feed.blog.interactor.BlogInteractorImpl
import com.mindorks.framework.mvp.ui.feed.blog.presenter.BlogPresenter
import com.mindorks.framework.mvp.ui.feed.blog.presenter.BlogPresenterImpl
import com.mindorks.framework.mvp.ui.feed.blog.view.BlogAdapter
import com.mindorks.framework.mvp.ui.feed.blog.view.BlogFragment
import com.mindorks.framework.mvp.ui.feed.blog.view.BlogView
import dagger.Module
import dagger.Provides
import java.util.*

/**
 * Created by jyotidubey on 14/01/18.
 */
@Module
class BlogFragmentModule {

    @Provides
    internal fun provideBlogInteractor(interactor: BlogInteractorImpl): BlogInteractor {
        return interactor
    }

    @Provides
    internal fun provideBlogPresenter(presenter: BlogPresenterImpl<BlogView, BlogInteractor>): BlogPresenter<BlogView, BlogInteractor> {
        return presenter
    }

    @Provides
    internal fun provideBlogAdapter(): BlogAdapter {
        return BlogAdapter(ArrayList())
    }

    @Provides
    internal fun provideLinearLayoutManager(fragment: BlogFragment): LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }
}