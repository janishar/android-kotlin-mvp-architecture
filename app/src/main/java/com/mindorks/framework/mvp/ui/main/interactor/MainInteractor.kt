package com.mindorks.framework.mvp.ui.main.interactor

import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Single

/**
 * Created by jyotidubey on 08/01/18.
 */
interface MainInteractor : MVPInteractor {
    fun getQuestionCardData(): Single<List<QuestionCardData>>
}