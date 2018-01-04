package com.mindorks.framework.mvp

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector

/**
 * Created by amitshekhar on 24/12/17.
 */
class MvpApp : Application() , HasActivityInjector {
    override fun activityInjector(): AndroidInjector<Activity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        super.onCreate()
    }

}