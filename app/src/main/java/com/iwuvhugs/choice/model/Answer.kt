package com.iwuvhugs.choice.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "answer",
        foreignKeys = arrayOf(ForeignKey(entity = Question::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("question_id"),
                onDelete = ForeignKey.CASCADE)))
data class Answer(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        @ColumnInfo(name = "question_id")
        val questionId: Long,
        @ColumnInfo(name = "answer")
        val answer: String)
