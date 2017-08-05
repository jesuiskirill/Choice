//package com.iwuvhugs.choice.model
//
//import android.arch.persistence.room.ColumnInfo
//import android.arch.persistence.room.Entity
//import android.arch.persistence.room.ForeignKey
//import android.arch.persistence.room.PrimaryKey
//import java.util.*
//
//@Entity(tableName = "answer",
//        foreignKeys = arrayOf(ForeignKey(entity = Question::class,
//                parentColumns = arrayOf("id"),
//                childColumns = arrayOf("question_id"),
//                onDelete = ForeignKey.CASCADE)))
//data class Answer(
//        @PrimaryKey(autoGenerate = true)
//        val id: Long,
//        @ColumnInfo(name = "question_id")
//        val questionId: UUID)