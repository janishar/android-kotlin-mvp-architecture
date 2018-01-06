package com.mindorks.framework.mvp.interactor.base.main

import com.mindorks.framework.mvp.data.database.repository.options.OptionsRepoHelper
import com.mindorks.framework.mvp.data.database.repository.questions.QuestionRepoHelper
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class MainInteractorImpl @Inject constructor(val questionRepoHelper: QuestionRepoHelper, val optionsRepoHelper: OptionsRepoHelper) : BaseInteractor(), MainInteractor {

    override fun seedQuestions(): Observable<Boolean> {
        return questionRepoHelper.insertQuestions(ArrayList())
    }

    override fun seedOptions(): Observable<Boolean> {
        return optionsRepoHelper.insertOptions(ArrayList())
    }

}