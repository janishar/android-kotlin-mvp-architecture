package com.mindorks.framework.mvp.ui.feed.opensource

import android.support.v7.widget.LinearLayoutManager
import com.mindorks.framework.mvp.ui.feed.opensource.interactor.OpenSourceMVPInteractor
import com.mindorks.framework.mvp.ui.feed.opensource.interactor.OpenSourceInterator
import com.mindorks.framework.mvp.ui.feed.opensource.presenter.OpenSourceMVPPresenter
import com.mindorks.framework.mvp.ui.feed.opensource.presenter.OpenSourcePresenter
import com.mindorks.framework.mvp.ui.feed.opensource.view.OpenSourceAdapter
import com.mindorks.framework.mvp.ui.feed.opensource.view.OpenSourceFragment
import com.mindorks.framework.mvp.ui.feed.opensource.view.OpenSourceMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 14/01/18.
 */
@Module
class OpenSourceFragmentModule {

    @Provides
    internal fun provideOpenSourceInteractor(interactor: OpenSourceInterator): OpenSourceMVPInteractor {
        return interactor
    }

    @Provides
    internal fun provideOpenSourcePresenter(presenter: OpenSourcePresenter<OpenSourceMVPView, OpenSourceMVPInteractor>): OpenSourceMVPPresenter<OpenSourceMVPView, OpenSourceMVPInteractor> {
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