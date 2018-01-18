package com.mindorks.framework.mvp.ui.splash.view

import com.mindorks.framework.mvp.ui.base.view.MVPView

/**
 * Created by jyotidubey on 04/01/18.
 */
interface SplashMVPView : MVPView {

    fun showSuccessToast()
    fun showErrorToast()
    fun openMainActivity()
    fun openLoginActivity()
}