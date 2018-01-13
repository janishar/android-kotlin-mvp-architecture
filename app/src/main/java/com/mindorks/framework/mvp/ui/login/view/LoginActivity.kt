package com.mindorks.framework.mvp.ui.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.login.interactor.LoginInteractor
import com.mindorks.framework.mvp.ui.login.presenter.LoginPresenter
import com.mindorks.framework.mvp.ui.main.view.MainActivity
import com.mindorks.framework.mvp.util.AppConstants
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

/**
 * Created by jyotidubey on 10/01/18.
 */
class LoginActivity : BaseActivity(), LoginView {

    @Inject
    internal lateinit var presenter: LoginPresenter<LoginView, LoginInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.onAttach(this)
        setOnClickListeners()

    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showValidationMessage(errorCode: Int) {
        when (errorCode) {
            AppConstants.EMPTY_EMAIL_ERROR -> Toast.makeText(this, getString(R.string.empty_email_error_message), Toast.LENGTH_LONG).show()
            AppConstants.INVALID_EMAIL_ERROR -> Toast.makeText(this, getString(R.string.invalid_email_error_message), Toast.LENGTH_LONG).show()
            AppConstants.EMPTY_PASSWORD_ERROR -> Toast.makeText(this, getString(R.string.empty_password_error_message), Toast.LENGTH_LONG).show()
            AppConstants.LOGIN_FAILURE -> Toast.makeText(this, getString(R.string.login_failure), Toast.LENGTH_LONG).show()

        }
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    fun setOnClickListeners() {
        btn_server_login.setOnClickListener { presenter.onServerLoginClicked(et_email.text.toString(), et_password.text.toString()) }
        ib_google_login.setOnClickListener { presenter.onGoogleLoginClicked() }
        ib_fb_login.setOnClickListener { presenter.onFBLoginClicked() }
    }


}