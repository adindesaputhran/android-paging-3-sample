package net.swift.android_paging_3_sample.service.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GithubEntity::class], version = 1)
abstract class AppDatabase(context: Context) : RoomDatabase() {
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return synchronized(this) {
                INSTANCE
                    ?: Room.databaseBuilder(context, AppDatabase::class.java, "paging_db.db")
                        .build()
                        .also { INSTANCE = it }
            }
        }
    }
}