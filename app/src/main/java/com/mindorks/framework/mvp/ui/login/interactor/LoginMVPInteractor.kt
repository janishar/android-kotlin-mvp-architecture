package com.mindorks.framework.mvp.ui.login.interactor

import com.mindorks.framework.mvp.data.network.LoginResponse
import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import com.mindorks.framework.mvp.util.AppConstants
import io.reactivex.Observable

/**
 * Created by jyotidubey on 10/01/18.
 */
interface LoginMVPInteractor : MVPInteractor {

    fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse>

    fun doFBLoginApiCall(): Observable<LoginResponse>

    fun doGoogleLoginApiCall(): Observable<LoginResponse>

    fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode)

}