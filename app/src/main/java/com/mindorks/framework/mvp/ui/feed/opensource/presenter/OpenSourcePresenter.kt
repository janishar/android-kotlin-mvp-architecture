package com.mindorks.framework.mvp.ui.feed.opensource.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.feed.opensource.interactor.OpenSourceInteractor
import com.mindorks.framework.mvp.ui.feed.opensource.view.OpenSourceView

/**
 * Created by jyotidubey on 14/01/18.
 */
interface OpenSourcePresenter<V : OpenSourceView, I : OpenSourceInteractor> : MVPPresenter<V, I> {
    fun onViewPrepared()

}