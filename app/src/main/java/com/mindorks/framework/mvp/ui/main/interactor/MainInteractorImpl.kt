package com.mindorks.framework.mvp.ui.main.interactor

import com.mindorks.framework.mvp.data.database.repository.options.Options
import com.mindorks.framework.mvp.data.database.repository.options.OptionsRepo
import com.mindorks.framework.mvp.data.database.repository.questions.Question
import com.mindorks.framework.mvp.data.database.repository.questions.QuestionRepo
import com.mindorks.framework.mvp.data.network.ApiHelper
import com.mindorks.framework.mvp.data.network.LogoutResponse
import com.mindorks.framework.mvp.data.preferences.PreferenceHelper
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by jyotidubey on 08/01/18.
 */
class MainInteractorImpl @Inject internal constructor(private val questionRepoHelper: QuestionRepo, private val optionsRepoHelper: OptionsRepo, preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper = preferenceHelper, apiHelper = apiHelper), MainInteractor {

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

    override fun getUserDetails(): Pair<String?, String?> {
        return Pair(preferenceHelper.getCurrentUserName(), preferenceHelper.getCurrentUserEmail())
    }

    override fun makeLogoutApiCall(): Observable<LogoutResponse> {
        return apiHelper.performLogoutApiCall()
    }
}


