package com.mindorks.framework.mvp.ui.splash.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.splash.interactor.SplashMVPInteractor
import com.mindorks.framework.mvp.ui.splash.view.SplashMVPView
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class SplashPresenter<V : SplashMVPView, I : SplashMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), SplashMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        feedInDatabase()
    }

    private fun feedInDatabase() {
        interactor?.let {
            compositeDisposable.add(it.seedQuestions()
                    .flatMap { interactor?.seedOptions() }
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({
                        if (getView() != null) {
                            decideActivityToOpen()
                        }
                    }))
        }
    }

    private fun decideActivityToOpen() {
        if (isUserLoggedIn()) {
            getView()?.openMainActivity()
        } else {
            getView()?.openLoginActivity()
        }
    }

    private fun isUserLoggedIn(): Boolean {
        interactor?.let { return it.isUserLoggedIn() }
        return false
    }

}