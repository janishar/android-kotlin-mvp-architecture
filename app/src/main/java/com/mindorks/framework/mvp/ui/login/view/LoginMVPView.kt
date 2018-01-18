package com.mindorks.framework.mvp.ui.login.view

import com.mindorks.framework.mvp.ui.base.view.MVPView

/**
 * Created by jyotidubey on 10/01/18.
 */
interface LoginMVPView : MVPView {

    fun showValidationMessage(errorCode: Int)
    fun openMainActivity()
}