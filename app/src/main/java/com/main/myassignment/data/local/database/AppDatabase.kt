package com.main.myassignment.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.main.myassignment.data.local.dao.PostDao
import com.main.myassignment.data.local.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
