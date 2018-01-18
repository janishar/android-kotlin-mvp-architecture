package com.mindorks.framework.mvp.ui.main.interactor

import com.mindorks.framework.mvp.data.network.LogoutResponse
import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by jyotidubey on 08/01/18.
 */
interface MainMVPInteractor : MVPInteractor {

    fun getQuestionCardData(): Single<List<QuestionCardData>>
    fun getUserDetails() : Pair<String?,String?>
    fun makeLogoutApiCall() : Observable<LogoutResponse>
}