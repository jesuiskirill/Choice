package com.iwuvhugs.choice

import android.app.Application
import android.arch.persistence.room.Room

class ChoiceApplication : Application() {

    companion object {
        var db: ChoiceDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, ChoiceDatabase::class.java, "choice_db").build()
    }
}