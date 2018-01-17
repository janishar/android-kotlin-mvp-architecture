package com.mindorks.framework.mvp.ui.feed.opensource.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.feed.opensource.interactor.OpenSourceMVPInteractor
import com.mindorks.framework.mvp.ui.feed.opensource.view.OpenSourceMVPView
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 14/01/18.
 */
class OpenSourcePresenter<V : OpenSourceMVPView, I : OpenSourceMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), OpenSourceMVPPresenter<V, I> {

    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.getOpenSourceList()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { openSourceResponse ->
                        getView()?.hideProgress()
                        getView()?.displayOpenSourceList(openSourceResponse.data)
                    })
        }

    }
}