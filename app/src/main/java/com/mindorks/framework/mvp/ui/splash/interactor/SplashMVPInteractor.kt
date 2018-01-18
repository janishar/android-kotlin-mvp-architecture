package com.mindorks.framework.mvp.ui.splash.interactor

import com.mindorks.framework.mvp.data.database.repository.questions.Question
import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

/**
 * Created by jyotidubey on 04/01/18.
 */
interface SplashMVPInteractor : MVPInteractor {

    fun seedQuestions(): Observable<Boolean>
    fun seedOptions(): Observable<Boolean>
    fun getQuestion() : Observable<List<Question>>
}