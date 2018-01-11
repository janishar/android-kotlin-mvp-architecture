package com.mindorks.framework.mvp.ui.login.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.login.interactor.LoginInteractor
import com.mindorks.framework.mvp.ui.login.view.LoginView

/**
 * Created by jyotidubey on 10/01/18.
 */
interface LoginPresenter<V : LoginView, I : LoginInteractor> : MVPPresenter<V, I> {
    fun onServerLoginClicked(emai: String, password: String)
    fun onFBLoginClicked()
    fun onGoogleLoginClicked()
}