package com.mindorks.framework.mvp.ui.main.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.main.interactor.MainMVPInteractor
import com.mindorks.framework.mvp.ui.main.view.MainMVPView

/**
 * Created by jyotidubey on 08/01/18.
 */
interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> : MVPPresenter<V, I> {

    fun refreshQuestionCards()
    fun onDrawerOptionAboutClick()
    fun onDrawerOptionRateUsClick()
    fun onDrawerOptionFeedClick()
    fun onDrawerOptionLogoutClick()

}