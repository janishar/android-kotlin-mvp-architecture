package com.mindorks.framework.mvp.ui.rate.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.rate.interactor.RateUsMVPInterator
import com.mindorks.framework.mvp.ui.rate.view.RateUsDialogMVPView
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 15/01/18.
 */
class RateUsPresenter<V : RateUsDialogMVPView, I : RateUsMVPInterator> @Inject internal constructor(interator: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interator, schedulerProvider = schedulerProvider,compositeDisposable = compositeDisposable), RateUsMVPPresenter<V, I> {

    override fun onLaterOptionClicked() {
        getView()?.let { it.dismissDialog() }
    }

    override fun onSubmitOptionClicked() {
        interactor?.let {
            it.submitRating()
            getView()?.let {
                it.showRatingSubmissionSuccessMessage()
                it.dismissDialog()
            }
        }
    }
}