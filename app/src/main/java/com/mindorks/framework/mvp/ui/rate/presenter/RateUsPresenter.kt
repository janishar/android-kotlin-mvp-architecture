package com.mindorks.framework.mvp.ui.rate.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.rate.interactor.RateUsInterator
import com.mindorks.framework.mvp.ui.rate.view.RateUsDialogView

/**
 * Created by jyotidubey on 15/01/18.
 */
interface RateUsPresenter<V : RateUsDialogView, I : RateUsInterator> : MVPPresenter<V, I> {
    fun onLaterOptionClicked()
    fun onSubmitOptionClicked()
}