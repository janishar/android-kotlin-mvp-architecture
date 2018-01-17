package com.mindorks.framework.mvp.ui.main.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.main.interactor.MainMVPInteractor
import com.mindorks.framework.mvp.ui.main.view.MainMVPView
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 08/01/18.
 */
class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider,compositeDisposable = disposable), MainMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        getUserData()
        getQuestionCards()
    }

    override fun refreshQuestionCards() {
        getQuestionCards()
    }

    override fun onDrawerOptionRateUsClick() {
        getView()?.openRateUsDialog()
    }

    override fun onDrawerOptionFeedClick() {
        getView()?.openFeedActivity()
    }

    override fun onDrawerOptionLogoutClick() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(
                    it.makeLogoutApiCall()
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe({
                                getView()?.hideProgress()
                                interactor?.performUserLogout()
                                getView()?.openLoginActivity()

                            }, {}))
        }

    }

    override fun onDrawerOptionAboutClick() {
        getView()?.openAboutFragment()
    }

    private fun getQuestionCards() {
        interactor?.let {
            compositeDisposable.add(it.getQuestionCardData()
                    .compose(schedulerProvider.ioToMainSingleScheduler())
                    .subscribe({ questionCard ->
                        getView()?.let {
                            if (questionCard.isEmpty()) return@subscribe
                            else it.displayQuestionCard(questionCard)
                        }
                    }, { err -> println(err) }))
        }

    }

    private fun getUserData() {
        interactor?.let {
            val userData = it.getUserDetails()
            getView()?.inflateUserDetails(userData)
        }

    }
}