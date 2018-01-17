package com.mindorks.framework.mvp.ui.feed.blog.interactor

import com.mindorks.framework.mvp.data.network.ApiHelper
import com.mindorks.framework.mvp.data.network.BlogResponse
import com.mindorks.framework.mvp.data.preferences.PreferenceHelper
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jyotidubey on 13/01/18.
 */
class BlogInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), BlogMVPInteractor {

    override fun getBlogList(): Observable<BlogResponse> {
        return apiHelper.getBlogApiCall()
    }
}