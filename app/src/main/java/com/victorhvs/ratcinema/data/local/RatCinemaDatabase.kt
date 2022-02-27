package com.victorhvs.ratcinema.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.victorhvs.ratcinema.data.local.dao.MovieDao
import com.victorhvs.ratcinema.data.local.dao.MovieRemoteKeyDao
import com.victorhvs.ratcinema.domain.Movie
import com.victorhvs.ratcinema.domain.MovieRemoteKey

@Database(
    entities =[Movie::class, MovieRemoteKey::class],
    version = 1
)
@TypeConverters(DatabaseConverter::class)
abstract class RatCinemaDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun movieRemoteKeyDao(): MovieRemoteKeyDao
}