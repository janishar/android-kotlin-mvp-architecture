package com.mindorks.framework.mvp.ui.rate.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.rate.interactor.RateUsInterator
import com.mindorks.framework.mvp.ui.rate.view.RateUsDialogView
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 15/01/18.
 */
class RateUsPresenterImpl<V : RateUsDialogView, I : RateUsInterator> @Inject internal constructor(interator: I, schedulerProvider: SchedulerProvider,compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interator, schedulerProvider = schedulerProvider,compositeDisposable = compositeDisposable), RateUsPresenter<V, I> {

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