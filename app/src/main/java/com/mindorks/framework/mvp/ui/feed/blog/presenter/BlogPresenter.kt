package com.mindorks.framework.mvp.ui.feed.blog.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.feed.blog.interactor.BlogInteractor
import com.mindorks.framework.mvp.ui.feed.blog.view.BlogView

/**
 * Created by jyotidubey on 13/01/18.
 */
interface BlogPresenter<V : BlogView, I : BlogInteractor> : MVPPresenter<V, I> {
    fun onViewPrepared()

}