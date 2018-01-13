package com.mindorks.framework.mvp.ui.base.presenter

import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import com.mindorks.framework.mvp.ui.base.view.MVPView
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by jyotidubey on 04/01/18.
 */
abstract class BasePresenter<V : MVPView, I : MVPInteractor> internal constructor(protected val interactor: I, protected val compositeDisposable: CompositeDisposable) : MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? {
        return view
    }

}