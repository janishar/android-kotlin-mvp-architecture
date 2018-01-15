package com.mindorks.framework.mvp.ui.rate.view

import com.mindorks.framework.mvp.ui.base.view.MVPView

/**
 * Created by jyotidubey on 14/01/18.
 */
interface RateUsDialogView : MVPView{
    fun dismissDialog()
    fun showRatingSubmissionSuccessMessage()
}