package com.mindorks.framework.mvp.ui.main.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.main.interactor.MainInteractor
import com.mindorks.framework.mvp.ui.main.view.MainView

/**
 * Created by jyotidubey on 04/01/18.
 */
interface MainPresenter<V : MainView, I : MainInteractor> : MVPPresenter<V, I> {
}