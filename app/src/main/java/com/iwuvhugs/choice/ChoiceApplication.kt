package com.iwuvhugs.choice

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
import android.arch.persistence.db.SupportSQLiteDatabase

class ChoiceApplication : Application() {

    companion object {
        var db: ChoiceDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, ChoiceDatabase::class.java, "choice_db")
                .addMigrations(
                        MIGRATION_1_2,
                        MIGRATION_2_3).build()
    }

    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `answer` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `question_id` INTEGER NOT NULL, FOREIGN KEY(`question_id`) REFERENCES `question`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )")
        }
    }

    val MIGRATION_2_3: Migration = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE `answer` ADD COLUMN `answer` TEXT NOT NULL DEFAULT ''")
        }
    }
}