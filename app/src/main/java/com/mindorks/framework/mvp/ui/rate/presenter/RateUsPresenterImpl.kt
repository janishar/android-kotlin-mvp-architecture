package com.mindorks.framework.mvp.ui.rate.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.rate.interactor.RateUsInterator
import com.mindorks.framework.mvp.ui.rate.view.RateUsDialogView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 15/01/18.
 */
class RateUsPresenterImpl<V : RateUsDialogView, I : RateUsInterator> @Inject internal constructor(interator: I, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interator, compositeDisposable = compositeDisposable), RateUsPresenter<V, I> {

    override fun onLaterOptionClicked() {
        getView()?.let { it.dismissDialog() }
    }

    override fun onSubmitOptionClicked() {
        interactor.submitRating()
        getView()?.let {
            it.showRatingSubmissionSuccessMessage()
            it.dismissDialog()
        }

    }

}