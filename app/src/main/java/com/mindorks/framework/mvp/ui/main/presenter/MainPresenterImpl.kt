package com.mindorks.framework.mvp.ui.main.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.main.interactor.MainInteractor
import com.mindorks.framework.mvp.ui.main.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by jyotidubey on 08/01/18.
 */
class MainPresenterImpl<V : MainView, I : MainInteractor> @Inject internal constructor(interactor: I, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor, disposable), MainPresenter<V, I> {

    override fun onAttach(view: V) {
        super.onAttach(view)
        getQuestionCards()
    }

    override fun refreshQuestionCards() {
        getQuestionCards()
    }

    private fun getQuestionCards() {
        compositeDisposable.add(interactor.getQuestionCardData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { questionCard ->
                    getView()?.displayQuestionCard(questionCard)

                })
    }
}