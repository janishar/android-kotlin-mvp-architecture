package com.mindorks.framework.mvp.ui.feed.opensource.interactor

import com.mindorks.framework.mvp.data.network.OpenSourceResponse
import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

/**
 * Created by jyotidubey on 14/01/18.
 */
interface OpenSourceInteractor : MVPInteractor {
    fun getOpenSourceList(): Observable<OpenSourceResponse>
}