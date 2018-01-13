package com.mindorks.framework.mvp.ui.splash.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.splash.interactor.SplashInteractor
import com.mindorks.framework.mvp.ui.splash.view.SplashView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class SplashPresenterImpl<V : SplashView, I : SplashInteractor> @Inject internal constructor(interactor: I, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor, disposable), SplashPresenter<V, I> {

    fun feedInDatabase() {
        compositeDisposable.add(interactor.seedQuestions()
                .flatMap { interactor.seedOptions() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (getView() != null) {
                        decideActivityToOpen()
                    }
                }))
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
        return interactor.isUserLoggedIn()
    }

}