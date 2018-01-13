package com.mindorks.framework.mvp.data.database.repository.questions

import io.reactivex.Observable

/**
 * Created by jyotidubey on 06/01/18.
 */
interface QuestionRepo {

    fun isQuestionsRepoEmpty(): Observable<Boolean>

    fun insertQuestions(questions: List<Question>): Observable<Boolean>

    fun loadQuestions(): Observable<List<Question>>

}