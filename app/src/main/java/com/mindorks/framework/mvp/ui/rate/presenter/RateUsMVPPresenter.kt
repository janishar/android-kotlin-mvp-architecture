package com.mindorks.framework.mvp.ui.rate.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.rate.interactor.RateUsMVPInterator
import com.mindorks.framework.mvp.ui.rate.view.RateUsDialogMVPView

/**
 * Created by jyotidubey on 15/01/18.
 */
interface RateUsMVPPresenter<V : RateUsDialogMVPView, I : RateUsMVPInterator> : MVPPresenter<V, I> {

    fun onLaterOptionClicked() : Unit?
    fun onSubmitOptionClicked() : Unit?
}