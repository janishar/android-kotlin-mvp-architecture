package com.mindorks.framework.mvp.ui.splash.view

import android.content.Intent
import android.os.Bundle
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.login.view.LoginActivity
import com.mindorks.framework.mvp.ui.main.view.MainActivity
import com.mindorks.framework.mvp.ui.splash.interactor.SplashMVPInteractor
import com.mindorks.framework.mvp.ui.splash.presenter.SplashMVPPresenter
import javax.inject.Inject

class SplashMVPActivity : BaseActivity(), SplashMVPView {

    @Inject
    lateinit var presenter: SplashMVPPresenter<SplashMVPView, SplashMVPInteractor>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun onFragmentAttached() {
    }

    override fun showSuccessToast() {
    }

    override fun showErrorToast() {
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
