package com.mindorks.framework.mvp.ui.feed.opensource.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.feed.opensource.interactor.OpenSourceInteractor
import com.mindorks.framework.mvp.ui.feed.opensource.view.OpenSourceView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by jyotidubey on 14/01/18.
 */
class OpenSourcePresenterImpl<V : OpenSourceView, I : OpenSourceInteractor> @Inject constructor(interactor: I, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, compositeDisposable = compositeDisposable), OpenSourcePresenter<V, I> {

    override fun onViewPrepared() {
        interactor.getOpenSourceList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { openSourceResponse ->
                    getView()?.displayOpenSourceList(openSourceResponse.data)
                }
    }


}