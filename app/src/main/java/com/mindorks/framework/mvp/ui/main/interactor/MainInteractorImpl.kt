package com.mindorks.framework.mvp.ui.main.interactor

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.internal.`$Gson$Types`
import com.mindorks.framework.mvp.data.database.repository.options.OptionsRepoHelper
import com.mindorks.framework.mvp.data.database.repository.questions.Question
import com.mindorks.framework.mvp.data.database.repository.questions.QuestionRepoHelper
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import com.mindorks.framework.mvp.util.AppConstants
import com.mindorks.framework.mvp.util.FileUtils
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class MainInteractorImpl @Inject constructor(val mContext: Context, val questionRepoHelper: QuestionRepoHelper, val optionsRepoHelper: OptionsRepoHelper) : BaseInteractor(), MainInteractor {
    override fun seedQuestions(): Observable<Boolean> {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()
        return questionRepoHelper.isQuestionsRepoEmpty().concatMap(Function
        { t ->
            if (t) {
                val type = `$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Question::class.java)
                val questionList = gson.fromJson<List<Question>>(
                        FileUtils.loadJSONFromAsset(
                                mContext,
                                AppConstants.SEED_DATABASE_QUESTIONS),
                        type)
                ObservableSource { questionRepoHelper.insertQuestions(questionList) }
            } else
                ObservableSource { Observable.just(false) }
        }
        )
    }

    override fun seedOptions(): Observable<Boolean> {
        return optionsRepoHelper.insertOptions(ArrayList())
    }


}