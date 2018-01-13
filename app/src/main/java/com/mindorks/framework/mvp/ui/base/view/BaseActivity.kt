package com.mindorks.framework.mvp.ui.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 * Created by jyotidubey on 04/01/18.
 */
abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    private fun performDI() {
        AndroidInjection.inject(this)
    }

}