package com.mindorks.framework.mvp.ui.login

import com.mindorks.framework.mvp.ui.login.interactor.LoginInteractor
import com.mindorks.framework.mvp.ui.login.interactor.LoginMVPInteractor
import com.mindorks.framework.mvp.ui.login.presenter.LoginMVPPresenter
import com.mindorks.framework.mvp.ui.login.presenter.LoginPresenter
import com.mindorks.framework.mvp.ui.login.view.LoginMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 10/01/18.
 */
@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginInteractor(interactor: LoginInteractor): LoginMVPInteractor = interactor

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginMVPView, LoginMVPInteractor>)
            : LoginMVPPresenter<LoginMVPView, LoginMVPInteractor> = presenter

}