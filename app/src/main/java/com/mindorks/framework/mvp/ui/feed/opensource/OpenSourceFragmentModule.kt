package com.mindorks.framework.mvp.ui.feed.opensource

import android.support.v7.widget.LinearLayoutManager
import com.mindorks.framework.mvp.ui.feed.opensource.interactor.OpenSourceInteractor
import com.mindorks.framework.mvp.ui.feed.opensource.interactor.OpenSourceInteratorImpl
import com.mindorks.framework.mvp.ui.feed.opensource.presenter.OpenSourcePresenter
import com.mindorks.framework.mvp.ui.feed.opensource.presenter.OpenSourcePresenterImpl
import com.mindorks.framework.mvp.ui.feed.opensource.view.OpenSourceAdapter
import com.mindorks.framework.mvp.ui.feed.opensource.view.OpenSourceFragment
import com.mindorks.framework.mvp.ui.feed.opensource.view.OpenSourceView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 14/01/18.
 */
@Module
class OpenSourceFragmentModule {

    @Provides
    internal fun provideOpenSourceInteractor(interactor: OpenSourceInteratorImpl): OpenSourceInteractor {
        return interactor
    }

    @Provides
    internal fun provideOpenSourcePresenter(presenter: OpenSourcePresenterImpl<OpenSourceView, OpenSourceInteractor>): OpenSourcePresenter<OpenSourceView, OpenSourceInteractor> {
        return presenter
    }

    @Provides
    internal fun provideOpenSourceAdapter(): OpenSourceAdapter {
        return OpenSourceAdapter(ArrayList())
    }

    @Provides
    internal fun provideLinearLayoutManager(fragment: OpenSourceFragment): LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }

}