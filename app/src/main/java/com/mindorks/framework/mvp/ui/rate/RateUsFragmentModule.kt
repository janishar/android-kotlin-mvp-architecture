package com.mindorks.framework.mvp.ui.rate

import com.mindorks.framework.mvp.ui.rate.interactor.RateUsInteractorImpl
import com.mindorks.framework.mvp.ui.rate.interactor.RateUsInterator
import com.mindorks.framework.mvp.ui.rate.presenter.RateUsPresenter
import com.mindorks.framework.mvp.ui.rate.presenter.RateUsPresenterImpl
import com.mindorks.framework.mvp.ui.rate.view.RateUsDialogView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 15/01/18.
 */
@Module
class RateUsFragmentModule{
    @Provides
    internal fun provideRateUsInteractor(interactor: RateUsInteractorImpl): RateUsInterator {
        return interactor
    }

    @Provides
    internal fun provideRateUsPresenter(presenter: RateUsPresenterImpl<RateUsDialogView, RateUsInterator>): RateUsPresenter<RateUsDialogView, RateUsInterator> {
        return presenter
    }

}       