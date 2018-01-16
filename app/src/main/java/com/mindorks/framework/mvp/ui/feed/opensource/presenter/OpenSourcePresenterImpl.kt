package com.mindorks.framework.mvp.ui.feed.opensource.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.feed.opensource.interactor.OpenSourceInteractor
import com.mindorks.framework.mvp.ui.feed.opensource.view.OpenSourceView
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by jyotidubey on 14/01/18.
 */
class OpenSourcePresenterImpl<V : OpenSourceView, I : OpenSourceInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), OpenSourcePresenter<V, I> {

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