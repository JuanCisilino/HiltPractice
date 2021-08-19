package com.frost.hiltpractice.di

import android.app.Application
import com.frost.hiltpractice.db.AppDao
import com.frost.hiltpractice.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APPModule {

    @Singleton
    @Provides
    fun getAppDB(application: Application): AppDatabase = AppDatabase.getAppDB(application)


    @Singleton
    @Provides
    fun getDao(appDB: AppDatabase): AppDao = appDB.getDAO()
}