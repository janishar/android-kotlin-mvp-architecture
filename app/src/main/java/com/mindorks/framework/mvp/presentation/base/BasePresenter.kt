package com.mindorks.framework.mvp.presentation.base

import com.mindorks.framework.mvp.interactor.base.MVPInteractor
import com.mindorks.framework.mvp.ui.base.MVPView

/**
 * Created by jyotidubey on 04/01/18.
 */
class BasePresenter<V : MVPView, I : MVPInteractor> : MVPPresenter {}