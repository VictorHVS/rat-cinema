package com.victorhvs.ratcinema.di

import android.content.Context
import androidx.room.Room
import com.victorhvs.ratcinema.data.local.RatCinemaDatabase
import com.victorhvs.ratcinema.data.repository.LocalDataSourceImpl
import com.victorhvs.ratcinema.data.repository.Repository
import com.victorhvs.ratcinema.domain.repository.LocalDataSource
import com.victorhvs.ratcinema.domain.repository.RemoteDataSource
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
    ): RatCinemaDatabase {
        return Room.databaseBuilder(
            context,
            RatCinemaDatabase::class.java,
            RATCINEMA_DATABASE
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: RatCinemaDatabase
    ): LocalDataSource = LocalDataSourceImpl(database)

    @Provides
    @Singleton
    fun provideRepository(
        local: LocalDataSource,
        remote: RemoteDataSource
    ): Repository = Repository(local, remote)
}