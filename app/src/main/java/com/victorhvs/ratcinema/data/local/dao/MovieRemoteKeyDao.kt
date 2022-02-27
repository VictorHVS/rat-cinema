package com.victorhvs.ratcinema.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.victorhvs.ratcinema.domain.MovieRemoteKey

@Dao
interface MovieRemoteKeyDao {

    @Query("SELECT * FROM movie_remote_key_table WHERE id = :id")
    suspend fun getRemoteKey(id: Int): MovieRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKeys: List<MovieRemoteKey>)

    @Query("DELETE FROM movie_remote_key_table")
    suspend fun deleteAllRemoteKeys()
}