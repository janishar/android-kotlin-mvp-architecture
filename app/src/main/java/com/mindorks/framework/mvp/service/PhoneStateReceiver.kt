package com.mindorks.framework.mvp.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mindorks.framework.mvp.data.network.ApiHelper
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by daniftodi on 2/3/18.
 */
class PhoneStateReceiver : BroadcastReceiver() {

    @Inject
    lateinit var apiHelper: ApiHelper

    override fun onReceive(context: Context, intent: Intent) {
        AndroidInjection.inject(this, context);

        //....

    }
}