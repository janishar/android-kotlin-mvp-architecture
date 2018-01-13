package com.mindorks.framework.mvp.ui.login.presenter

import com.mindorks.framework.mvp.data.network.LoginResponse
import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.login.interactor.LoginInteractor
import com.mindorks.framework.mvp.ui.login.view.LoginView
import com.mindorks.framework.mvp.util.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by jyotidubey on 10/01/18.
 */
class LoginPresenterImpl<V : LoginView, I : LoginInteractor> @Inject internal constructor(interactor: I, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, compositeDisposable = disposable), LoginPresenter<V, I> {

    override fun onServerLoginClicked(email: String, password: String) {
        when {
            email.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_EMAIL_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_PASSWORD_ERROR)
            else -> compositeDisposable.add(interactor.doServerLoginApiCall(email, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
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

    override fun onFBLoginClicked() {
        compositeDisposable.add(interactor.doFBLoginApiCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { loginResponse ->
                    updateUserInSharedPref(loginResponse = loginResponse, loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_FB)
                    getView()?.openMainActivity()
                })

    }

    override fun onGoogleLoginClicked() {
        compositeDisposable.add(interactor.doGoogleLoginApiCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { loginResponse ->
                    updateUserInSharedPref(loginResponse = loginResponse, loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_GOOGLE)
                    getView()?.openMainActivity()

                })
    }

    private fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode) {
        interactor.updateUserInSharedPref(loginResponse, loggedInMode)
    }

}