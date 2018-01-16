package com.mindorks.framework.mvp.ui.feed.blog.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.feed.blog.interactor.BlogInteractor
import com.mindorks.framework.mvp.ui.feed.blog.view.BlogView
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by jyotidubey on 13/01/18.
 */
class BlogPresenterImpl<V : BlogView, I : BlogInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), BlogPresenter<V, I> {

    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            it.getBlogList()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { blogResponse ->
                        getView()?.hideProgress()
                        getView()?.displayBlogList(blogResponse.data)
                    }
        }
    }


}