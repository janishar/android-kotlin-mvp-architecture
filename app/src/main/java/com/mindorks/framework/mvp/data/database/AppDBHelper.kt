package com.mindorks.framework.mvp.data.database

import com.mindorks.framework.mvp.data.database.repository.options.Options
import com.mindorks.framework.mvp.data.database.repository.questions.Question
import com.mindorks.framework.mvp.data.database.repository.user.User
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class AppDBHelper @Inject constructor(appDatabase : AppDatabase) : DBHelper {


    var appDatabase = appDatabase

    override fun insertQuestions(questions: List<Question>) {
        appDatabase?.questionsDao()?.insertAll(questions)

    }

    override fun insertOptions(options: List<Options>) {
        appDatabase?.optionsDao()?.insertAll(options)

    }

    override fun loadQuestions(): List<Question>? {
        return appDatabase?.questionsDao()?.loadAll()
    }

    override fun loadOptions(questionId : String): List<Options>? {
        return appDatabase?.optionsDao()?.loadAll(questionId)

    }

    override fun insertUser(user: User) {
        appDatabase?.userDao()?.insert(user)
    }

    override fun loadUsers(): List<User>? {
        return appDatabase?.userDao().getUser()
    }

}