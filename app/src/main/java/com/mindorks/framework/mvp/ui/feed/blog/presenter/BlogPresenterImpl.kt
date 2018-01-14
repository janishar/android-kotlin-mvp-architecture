package com.mindorks.framework.mvp.ui.feed.blog.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.feed.blog.interactor.BlogInteractor
import com.mindorks.framework.mvp.ui.feed.blog.view.BlogView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by jyotidubey on 13/01/18.
 */
class BlogPresenterImpl<V : BlogView, I : BlogInteractor> @Inject constructor(interactor: I, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, compositeDisposable = compositeDisposable), BlogPresenter<V, I> {

    override fun onViewPrepared() {
        interactor.getBlogList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { blogResponse ->
                    getView()?.displayBlogList(blogResponse.data)
                }
    }


}