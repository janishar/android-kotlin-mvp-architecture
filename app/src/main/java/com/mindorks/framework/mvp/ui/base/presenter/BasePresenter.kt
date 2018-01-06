package com.mindorks.framework.mvp.ui.base.presenter

import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import com.mindorks.framework.mvp.ui.base.view.MVPView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
open class BasePresenter<V : MVPView, I : MVPInteractor>() : MVPPresenter<V, I> {


    private lateinit var compositeDisposable: CompositeDisposable
    private lateinit var view: V
    private lateinit var interactor: I

    @Inject constructor(interactor: I, compositeDisposable: CompositeDisposable) : this() {
        this.interactor = interactor
        this.compositeDisposable = compositeDisposable
    }

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun getView(): V {
        return view
    }

    override fun getInteractor(): I {
        return interactor
    }

    fun getCompositeDisposable(): CompositeDisposable {
        return compositeDisposable;
    }

}