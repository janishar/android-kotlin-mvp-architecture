package com.mindorks.framework.mvp

import android.app.Activity
import android.app.Application
import android.content.BroadcastReceiver
import com.mindorks.framework.mvp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasBroadcastReceiverInjector
import javax.inject.Inject

/**
 * Created by amitshekhar on 24/12/17.
 */
class MvpApp : Application(), HasActivityInjector, HasBroadcastReceiverInjector {


    @Inject
    lateinit internal var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit internal var broadcastReceiverInjector: DispatchingAndroidInjector<BroadcastReceiver>

    override fun activityInjector() = activityDispatchingAndroidInjector

    override fun broadcastReceiverInjector(): AndroidInjector<BroadcastReceiver> = broadcastReceiverInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

}