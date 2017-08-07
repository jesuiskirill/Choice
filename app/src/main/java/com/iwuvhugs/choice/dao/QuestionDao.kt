package com.iwuvhugs.choice.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.iwuvhugs.choice.model.Question

@Dao
interface QuestionDao {

    @Query("SELECT * FROM question")
    fun getQuestions(): List<Question>

    @Insert
    fun insert(question: Question)
}