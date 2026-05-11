package com.main.myassignment.di

import android.content.Context
import android.content.pm.ApplicationInfo
import androidx.room.Room
import com.main.myassignment.data.local.dao.PostDao
import com.main.myassignment.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_db").apply {
            if (context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0) {
                fallbackToDestructiveMigration()
            }
        }.build()

    @Provides
    @Singleton
    fun provideDao(db: AppDatabase): PostDao = db.postDao()
}
