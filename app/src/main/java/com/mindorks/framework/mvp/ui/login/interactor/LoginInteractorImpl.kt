package com.mindorks.framework.mvp.ui.login.interactor

import com.mindorks.framework.mvp.data.network.ApiHelper
import com.mindorks.framework.mvp.data.network.LoginRequest
import com.mindorks.framework.mvp.data.network.LoginResponse
import com.mindorks.framework.mvp.data.preferences.PreferenceHelper
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import com.mindorks.framework.mvp.util.AppConstants
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jyotidubey on 10/01/18.
 */
class LoginInteractorImpl @Inject internal constructor(val apiHelper: ApiHelper, val preferenceHelper: PreferenceHelper) : BaseInteractor(), LoginInteractor {

    override fun doGoogleLoginApiCall(): Observable<LoginResponse> {
        return apiHelper.performGoogleLogin(LoginRequest.GoogleLoginRequest("test1", "test1"))
    }

    override fun doFBLoginApiCall(): Observable<LoginResponse> {
        return apiHelper.performFBLogin(LoginRequest.FacebookLoginRequest("test3", "test4"))
    }

    override fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse> {
        return return apiHelper.performServerLogin(LoginRequest.ServerLoginRequest(email = email, password = password))
    }


    override fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode) {
        preferenceHelper.setCurrentUserId(loginResponse.userId)
        preferenceHelper.setAccessToken(loginResponse.accessToken)
        preferenceHelper.setCurrentUserLoggedInMode(loggedInMode)
    }


}