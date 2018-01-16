package com.mindorks.framework.mvp.ui.splash.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.splash.interactor.SplashInteractor
import com.mindorks.framework.mvp.ui.splash.view.SplashView
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class SplashPresenterImpl<V : SplashView, I : SplashInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), SplashPresenter<V, I> {

    fun feedInDatabase() {
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

    override fun onAttach(view: V?) {
        super.onAttach(view)
        feedInDatabase()

    }

    fun decideActivityToOpen() {
        if (isUserLoggedIn()) {
            getView()?.openMainActivity()
        } else {
            getView()?.openLoginActivity()
        }
    }

    fun isUserLoggedIn(): Boolean {
        interactor?.let { return it.isUserLoggedIn() }
        return false
    }

}