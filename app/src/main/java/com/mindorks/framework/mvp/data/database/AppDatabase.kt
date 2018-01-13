package com.mindorks.framework.mvp.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.mindorks.framework.mvp.data.database.repository.options.Options
import com.mindorks.framework.mvp.data.database.repository.options.OptionsDao
import com.mindorks.framework.mvp.data.database.repository.questions.Question
import com.mindorks.framework.mvp.data.database.repository.questions.QuestionsDao

/**
 * Created by jyotidubey on 03/01/18.
 */
@Database(entities = [(Question::class), (Options::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun optionsDao(): OptionsDao

    abstract fun questionsDao(): QuestionsDao

}