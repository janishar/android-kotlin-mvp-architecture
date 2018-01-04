package com.mindorks.framework.mvp.data.database

import com.mindorks.framework.mvp.data.database.repository.options.Options
import com.mindorks.framework.mvp.data.database.repository.questions.Question
import com.mindorks.framework.mvp.data.database.repository.user.User

/**
 * Created by jyotidubey on 03/01/18.
 */
interface DBHelper {

    fun insertUser(user: User)

    fun insertQuestions(questions: List<Question>)

    fun insertOptions(options: List<Options>)

    fun loadQuestions(): List<Question>?

    fun loadOptions(questionId : String): List<Options>?

}