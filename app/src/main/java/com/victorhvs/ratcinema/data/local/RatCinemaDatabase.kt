package com.victorhvs.ratcinema.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.victorhvs.ratcinema.data.local.dao.MovieDao
import com.victorhvs.ratcinema.data.local.dao.MovieRemoteKeysDao
import com.victorhvs.ratcinema.domain.model.Movie
import com.victorhvs.ratcinema.domain.model.MovieRemoteKeys

@Database(
    entities =[Movie::class, MovieRemoteKeys::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DatabaseConverter::class)
abstract class RatCinemaDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun movieRemoteKeysDao(): MovieRemoteKeysDao
}