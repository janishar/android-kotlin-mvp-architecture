package com.mindorks.framework.mvp.data.database.repository.questions

import io.reactivex.Observable

/**
 * Created by jyotidubey on 06/01/18.
 */
interface QuestionRepoHelper {
     fun insertQuestions(questions: List<Question>) : Observable<Boolean>
     fun loadQuestions(): List<Question>?
}