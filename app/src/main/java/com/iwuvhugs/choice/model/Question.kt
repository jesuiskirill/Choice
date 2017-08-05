package com.iwuvhugs.choice.model

import android.arch.persistence.room.*
import java.util.*

@Entity(tableName = "question")
data class Question(
        @PrimaryKey(autoGenerate = true)
        var id: Long,
        @ColumnInfo(name = "title")
        var title: String,
        @ColumnInfo(name = "description")
        var description: String
)

//data class QuestionWithAnswers(
//        @Embedded
//        var question: Question,
//        @Relation(parentColumn = "id", entityColumn = "id", entity = Answer::class)
//        var answers: List<Answer>)