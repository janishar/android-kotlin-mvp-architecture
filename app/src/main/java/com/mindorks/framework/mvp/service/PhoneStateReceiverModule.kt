package com.mindorks.framework.mvp.service

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by daniftodi on 2/3/18.
 */
@Module
abstract class PhoneStateReceiverModule {
    @ContributesAndroidInjector
    abstract fun providersPhoneStateReceiver():PhoneStateReceiver;
}