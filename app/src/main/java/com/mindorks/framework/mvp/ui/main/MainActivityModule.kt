package com.mindorks.framework.mvp.ui.main

import com.mindorks.framework.mvp.ui.main.interactor.MainInteractor
import com.mindorks.framework.mvp.ui.main.interactor.MainMVPInteractor
import com.mindorks.framework.mvp.ui.main.presenter.MainMVPPresenter
import com.mindorks.framework.mvp.ui.main.presenter.MainPresenter
import com.mindorks.framework.mvp.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 09/01/18.
 */
@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMVPInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>)
            : MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter

}