package com.mindorks.framework.mvp.ui.main

import android.os.Bundle
import android.widget.Toast
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.DataManager
import com.mindorks.framework.mvp.data.database.repository.user.User
import com.mindorks.framework.mvp.ui.base.BaseView
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseView(), MainView {

    @Inject
    lateinit internal var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
