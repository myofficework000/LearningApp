package com.example.learningapp.di

import android.content.Context
import com.example.learningapp.modal.local.AppDatabase
import com.example.learningapp.modal.local.UserDao
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
    fun provideUserDao(@ApplicationContext context: Context): UserDao {
        return AppDatabase.getAppDatabase(context)!!.getUserDao()
    }
}