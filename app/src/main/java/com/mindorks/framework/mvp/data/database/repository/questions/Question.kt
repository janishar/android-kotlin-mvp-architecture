package com.mindorks.framework.mvp.data.database.repository.questions

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by jyotidubey on 03/01/18.
 */
@Entity(tableName = "questions")
data class Question(
        @Expose
        @PrimaryKey
        var id: Long,

        @SerializedName("question_text")
        @ColumnInfo(name = "question_text")
        var questionText: String,

        @Expose
        @SerializedName("question_img_url")
        @ColumnInfo(name = "question_img_url")
        var imgUrl: String,

        @Expose
        @SerializedName("created_at")
        @ColumnInfo(name = "created_at")
        var createdAt: String,

        @Expose
        @SerializedName("updated_at")
        @ColumnInfo(name = "updated_at")
        var updatedAt: String

)