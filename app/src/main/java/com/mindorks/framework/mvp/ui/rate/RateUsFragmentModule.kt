package com.mindorks.framework.mvp.ui.rate

import com.mindorks.framework.mvp.ui.rate.interactor.RateUsInteractor
import com.mindorks.framework.mvp.ui.rate.interactor.RateUsMVPInterator
import com.mindorks.framework.mvp.ui.rate.presenter.RateUsMVPPresenter
import com.mindorks.framework.mvp.ui.rate.presenter.RateUsPresenter
import com.mindorks.framework.mvp.ui.rate.view.RateUsDialogMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 15/01/18.
 */
@Module
class RateUsFragmentModule{

    @Provides
    internal fun provideRateUsInteractor(interactor: RateUsInteractor): RateUsMVPInterator {
        return interactor
    }

    @Provides
    internal fun provideRateUsPresenter(presenter: RateUsPresenter<RateUsDialogMVPView, RateUsMVPInterator>): RateUsMVPPresenter<RateUsDialogMVPView, RateUsMVPInterator> {
        return presenter
    }
}