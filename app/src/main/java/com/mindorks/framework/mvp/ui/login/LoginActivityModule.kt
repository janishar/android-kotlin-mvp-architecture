package com.mindorks.framework.mvp.ui.login

import com.mindorks.framework.mvp.ui.login.interactor.LoginInteractor
import com.mindorks.framework.mvp.ui.login.interactor.LoginInteractorImpl
import com.mindorks.framework.mvp.ui.login.presenter.LoginPresenter
import com.mindorks.framework.mvp.ui.login.presenter.LoginPresenterImpl
import com.mindorks.framework.mvp.ui.login.view.LoginView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 10/01/18.
 */
@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginInteractor(interactor: LoginInteractorImpl): LoginInteractor {
        return interactor
    }

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenterImpl<LoginView, LoginInteractor>): LoginPresenter<LoginView, LoginInteractor> {
        return presenter
    }
}