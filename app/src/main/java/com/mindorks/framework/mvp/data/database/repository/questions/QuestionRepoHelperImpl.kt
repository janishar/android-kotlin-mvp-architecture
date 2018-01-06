package com.mindorks.framework.mvp.data.database.repository.questions

import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jyotidubey on 06/01/18.
 */
class QuestionRepoHelperImpl @Inject constructor(val questionsDao: QuestionsDao) : QuestionRepoHelper {

    override fun insertQuestions(questions: List<Question>) : Observable<Boolean> {
         questionsDao.insertAll(questions)
         return Observable.just(true)

    }

    override fun loadQuestions(): List<Question>? {
        return questionsDao.loadAll()
    }
}
