package com.mindorks.framework.mvp.ui.login.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.login.interactor.LoginMVPInteractor
import com.mindorks.framework.mvp.ui.login.view.LoginMVPView

/**
 * Created by jyotidubey on 10/01/18.
 */
interface LoginMVPPresenter<V : LoginMVPView, I : LoginMVPInteractor> : MVPPresenter<V, I> {

    fun onServerLoginClicked(email: String, password: String)
    fun onFBLoginClicked()
    fun onGoogleLoginClicked()

}