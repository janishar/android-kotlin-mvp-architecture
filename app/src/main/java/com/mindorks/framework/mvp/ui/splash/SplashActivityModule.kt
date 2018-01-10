package com.mindorks.framework.mvp.ui.splash

import com.mindorks.framework.mvp.ui.splash.interactor.SplashInteractor
import com.mindorks.framework.mvp.ui.splash.interactor.SplashInteractorImpl
import com.mindorks.framework.mvp.ui.splash.presenter.SplashPresenter
import com.mindorks.framework.mvp.ui.splash.presenter.SplashPresenterImpl
import com.mindorks.framework.mvp.ui.splash.view.SplashView
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by jyotidubey on 06/01/18.
 */
@Module
class SplashActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractorImpl: SplashInteractorImpl): SplashInteractor {
        return mainInteractorImpl
    }

    @Provides
    internal fun provideMainPresenter(mainPresenterImpl: SplashPresenterImpl<SplashView, SplashInteractor>): SplashPresenter<SplashView, SplashInteractor> {
        return mainPresenterImpl
    }

}