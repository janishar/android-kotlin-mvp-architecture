package com.mindorks.framework.mvp.ui.main.interactor

import com.mindorks.framework.mvp.data.database.repository.options.Options
import com.mindorks.framework.mvp.data.database.repository.options.OptionsRepoHelper
import com.mindorks.framework.mvp.data.database.repository.questions.Question
import com.mindorks.framework.mvp.data.database.repository.questions.QuestionRepoHelper
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by jyotidubey on 08/01/18.
 */
class MainInteractorImpl @Inject internal constructor(val questionRepoHelper: QuestionRepoHelper, val optionsRepoHelper: OptionsRepoHelper) : BaseInteractor(), MainInteractor {

    override fun getQuestionCardData(): Single<List<QuestionCardData>> {
        return questionRepoHelper.loadQuestions()
                .flatMapIterable { question -> question }
                .flatMapSingle { question -> getQuestionCards(question) }
                .toList()
    }

    fun getQuestionCards(question: Question): Single<QuestionCardData> {
        return optionsRepoHelper.loadOptions(question.id).map { options -> createQuestionCard(options, question) }

    }

    fun createQuestionCard(options: List<Options>, question: Question): QuestionCardData {
        return QuestionCardData(options, question)
    }
}


