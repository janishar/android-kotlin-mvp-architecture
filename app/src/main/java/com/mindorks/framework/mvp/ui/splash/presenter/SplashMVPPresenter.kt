package com.mindorks.framework.mvp.ui.splash.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.splash.interactor.SplashMVPInteractor
import com.mindorks.framework.mvp.ui.splash.view.SplashMVPView

/**
 * Created by jyotidubey on 04/01/18.
 */
interface SplashMVPPresenter<V : SplashMVPView, I : SplashMVPInteractor> : MVPPresenter<V,I>