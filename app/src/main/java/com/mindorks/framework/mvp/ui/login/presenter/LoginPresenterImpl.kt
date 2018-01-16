package com.mindorks.framework.mvp.ui.login.presenter

import com.mindorks.framework.mvp.data.network.LoginResponse
import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.login.interactor.LoginInteractor
import com.mindorks.framework.mvp.ui.login.view.LoginView
import com.mindorks.framework.mvp.util.AppConstants
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by jyotidubey on 10/01/18.
 */
class LoginPresenterImpl<V : LoginView, I : LoginInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), LoginPresenter<V, I> {

    override fun onServerLoginClicked(email: String, password: String) {
        when {
            email.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_EMAIL_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_PASSWORD_ERROR)
            else -> {
                getView()?.showProgress()
                interactor?.let {
                    compositeDisposable.add(it.doServerLoginApiCall(email, password)
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe({ loginResponse ->
                                if ("success" == loginResponse.message.toString()) {
                                    updateUserInSharedPref(loginResponse = loginResponse, loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
                                    getView()?.openMainActivity()
                                } else {
                                    getView()?.showValidationMessage(AppConstants.LOGIN_FAILURE)
                                }
                            }))
                }

            }
        }
    }

    override fun onFBLoginClicked() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.doFBLoginApiCall()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { loginResponse ->
                        getView()?.hideProgress()
                        updateUserInSharedPref(loginResponse = loginResponse, loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_FB)
                        getView()?.openMainActivity()
                    })
        }


    }

    override fun onGoogleLoginClicked() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.doGoogleLoginApiCall()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { loginResponse ->
                        getView()?.hideProgress()
                        updateUserInSharedPref(loginResponse = loginResponse, loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_GOOGLE)
                        getView()?.openMainActivity()
                    })
        }

    }

    private fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode) {
        interactor?.updateUserInSharedPref(loginResponse, loggedInMode)
    }

}