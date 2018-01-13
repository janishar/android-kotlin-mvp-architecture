package com.mindorks.framework.mvp.ui.main

import com.mindorks.framework.mvp.ui.main.interactor.MainInteractor
import com.mindorks.framework.mvp.ui.main.interactor.MainInteractorImpl
import com.mindorks.framework.mvp.ui.main.presenter.MainPresenter
import com.mindorks.framework.mvp.ui.main.presenter.MainPresenterImpl
import com.mindorks.framework.mvp.ui.main.view.MainView
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by jyotidubey on 09/01/18.
 */
@Module
class MainActivityModule {


    @Provides
    internal fun provideMainInteractor(mainInteractorImpl: MainInteractorImpl): MainInteractor {
        return mainInteractorImpl
    }

    @Provides
    internal fun provideMainPresenter(mainPresenterImpl: MainPresenterImpl<MainView, MainInteractor>): MainPresenter<MainView, MainInteractor> {
        return mainPresenterImpl
    }
}