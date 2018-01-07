package com.mindorks.framework.mvp.ui.main.view

import android.os.Bundle
import android.widget.Toast
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.main.interactor.MainInteractor
import com.mindorks.framework.mvp.ui.main.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter<MainView, MainInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
    }

    override fun showSuccessToast() {
        Toast.makeText(this, "Testing:: Questions Added Successfully", Toast.LENGTH_LONG).show()
    }

    override fun showErrorToast() {
        Toast.makeText(this, "Testing:: Questions Adding Failed", Toast.LENGTH_LONG).show()
    }
}
