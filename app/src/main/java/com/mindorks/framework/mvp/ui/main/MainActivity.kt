package com.mindorks.framework.mvp.ui.main

import android.os.Bundle
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.base.BaseView

class MainActivity : BaseView(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
