package com.mindorks.framework.mvp.ui.feed.blog.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.feed.blog.interactor.BlogMVPInteractor
import com.mindorks.framework.mvp.ui.feed.blog.view.BlogMVPView

/**
 * Created by jyotidubey on 13/01/18.
 */
interface BlogMVPPresenter<V : BlogMVPView, I : BlogMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared()
}