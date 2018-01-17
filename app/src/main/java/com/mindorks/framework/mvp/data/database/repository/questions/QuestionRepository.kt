package com.mindorks.framework.mvp.data.database.repository.questions

import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jyotidubey on 06/01/18.
 */
class QuestionRepository @Inject internal constructor(private val questionsDao: QuestionsDao) : QuestionRepo {

    override fun isQuestionsRepoEmpty(): Observable<Boolean> {
        return Observable.fromCallable({ questionsDao.loadAll().isEmpty() })
    }

    override fun insertQuestions(questions: List<Question>): Observable<Boolean> {
        questionsDao.insertAll(questions)
        return Observable.just(true)
    }

    override fun loadQuestions(): Observable<List<Question>> {
        return Observable.fromCallable({ questionsDao.loadAll() })
    }

}
