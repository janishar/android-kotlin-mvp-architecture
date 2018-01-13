package com.mindorks.framework.mvp.ui.base.interactor

import com.mindorks.framework.mvp.data.network.ApiHelper
import com.mindorks.framework.mvp.data.preferences.PreferenceHelper
import com.mindorks.framework.mvp.util.AppConstants

/**
 * Created by jyotidubey on 04/01/18.
 */
open class BaseInteractor() : MVPInteractor {

    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper


    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }


    override fun isUserLoggedIn(): Boolean {
        return this.preferenceHelper.getCurrentUserLoggedInMode() != AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type
    }

    override fun performUserLogout() {
        this.preferenceHelper.setCurrentUserId(null)
        this.preferenceHelper.setAccessToken(null)
        this.preferenceHelper.setCurrentUserEmail(null)
        this.preferenceHelper.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT)
    }


}