package com.iwuvhugs.choice

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.iwuvhugs.choice.dao.QuestionDao
import com.iwuvhugs.choice.model.Question

@Database(entities = arrayOf(
        Question::class),
//        Answer::class),
        version = 1)
abstract class ChoiceDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao
//    abstract fun answerDao(): AnswerDao
}