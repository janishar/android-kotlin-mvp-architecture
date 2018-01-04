package com.mindorks.framework.mvp.data.database.repository.user

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by jyotidubey on 03/01/18.
 */
@Entity(tableName = "users")
data class User(
        @PrimaryKey
        var id: Long,

        var name: String,

        @ColumnInfo(name = "created_at")
        val createdAt: String,

        @ColumnInfo(name = "updated_at")
        var updatedAt: String
)
