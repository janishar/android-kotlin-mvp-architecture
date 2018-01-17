package com.mindorks.framework.mvp.ui.feed.opensource.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.feed.opensource.interactor.OpenSourceMVPInteractor
import com.mindorks.framework.mvp.ui.feed.opensource.view.OpenSourceMVPView

/**
 * Created by jyotidubey on 14/01/18.
 */
interface OpenSourceMVPPresenter<V : OpenSourceMVPView, I : OpenSourceMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared()
}