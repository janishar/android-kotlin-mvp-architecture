package com.mindorks.framework.mvp.ui.main.presenter

import com.mindorks.framework.mvp.interactor.base.main.MainInteractor
import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.main.view.MainView

/**
 * Created by jyotidubey on 04/01/18.
 */
class MainPresenterImpl<V : MainView, I : MainInteractor> : BasePresenter<V, I>(), MainPresenter<V, I> {

    fun seedQuestions() {
        getCompositeDisposable().add(getInteractor().seedQuestions().subscribe())
    }

    fun seedOptions() {
        getCompositeDisposable().add(getInteractor().seedOptions().subscribe())
    }

    override fun onAttach(view: V) {
        super.onAttach(view)
        seedQuestions()
        seedOptions()
    }
}