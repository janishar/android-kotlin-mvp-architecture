package com.mindorks.framework.mvp.data.database.repository.user

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by jyotidubey on 03/01/18.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM users")
    fun getUser() : List<User>
}