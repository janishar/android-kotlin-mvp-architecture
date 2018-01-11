package com.mindorks.framework.mvp.ui.login.view

import com.mindorks.framework.mvp.ui.base.view.MVPView

/**
 * Created by jyotidubey on 10/01/18.
 */
interface LoginView : MVPView {

    fun showValidationMessage(errorCode: Int)
    fun openMainActivity();
}