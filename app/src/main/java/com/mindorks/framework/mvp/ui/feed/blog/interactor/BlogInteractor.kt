package com.mindorks.framework.mvp.ui.feed.blog.interactor

import com.mindorks.framework.mvp.data.network.BlogResponse
import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

/**
 * Created by jyotidubey on 13/01/18.
 */
interface BlogInteractor : MVPInteractor {
    fun getBlogList(): Observable<BlogResponse>
}