package com.mindorks.framework.mvp.ui.splash.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.splash.interactor.SplashInteractor
import com.mindorks.framework.mvp.ui.splash.view.SplashView

/**
 * Created by jyotidubey on 04/01/18.
 */
interface SplashPresenter<V : SplashView, I : SplashInteractor> : MVPPresenter<V,I> {
}