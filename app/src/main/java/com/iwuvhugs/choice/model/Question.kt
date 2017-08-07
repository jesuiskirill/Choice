package com.iwuvhugs.choice.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "question")
data class Question(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        @ColumnInfo(name = "title")
        var title: String,
        @ColumnInfo(name = "description")
        var description: String
) {
    @Ignore
    constructor(title: String, description: String) : this(0, title, description)
}

//data class QuestionWithAnswers(
//        @Embedded
//        var question: Question,
//        @Relation(parentColumn = "id", entityColumn = "id", entity = Answer::class)
//        var answers: List<Answer>)