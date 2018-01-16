package com.mindorks.framework.mvp.ui.splash.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.login.view.LoginActivity
import com.mindorks.framework.mvp.ui.main.view.MainActivity
import com.mindorks.framework.mvp.ui.splash.interactor.SplashInteractor
import com.mindorks.framework.mvp.ui.splash.presenter.SplashPresenter
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashView {

    @Inject
    lateinit var presenter: SplashPresenter<SplashView, SplashInteractor>

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSuccessToast() {
        Toast.makeText(this, "Testing:: Questions Added Successfully", Toast.LENGTH_LONG).show()
    }

    override fun showErrorToast() {
        Toast.makeText(this, "Testing:: Questions Adding Failed", Toast.LENGTH_LONG).show()
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
