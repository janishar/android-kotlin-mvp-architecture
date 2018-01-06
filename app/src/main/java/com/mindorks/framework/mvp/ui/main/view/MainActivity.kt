package com.mindorks.framework.mvp.ui.main.view

import android.os.Bundle
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.interactor.base.main.MainInteractor
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.main.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter<MainActivity, MainInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
    }
}
