package com.victorhvs.ratcinema.di

import android.content.Context
import androidx.room.Room
import com.victorhvs.ratcinema.data.local.RatCinemaDatabase
import com.victorhvs.ratcinema.util.Constants.RATCINEMA_DATABASE
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
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RatCinemaDatabase::class.java,
        RATCINEMA_DATABASE
    )
}