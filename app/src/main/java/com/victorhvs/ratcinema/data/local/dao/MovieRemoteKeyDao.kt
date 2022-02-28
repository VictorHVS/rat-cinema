package com.victorhvs.ratcinema.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.victorhvs.ratcinema.domain.model.MovieRemoteKeys

@Dao
interface MovieRemoteKeysDao {

    @Query("SELECT * FROM movie_remote_keys_table WHERE id = :movieId")
    suspend fun getRemoteKeys(movieId: Int): MovieRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(movieRemoteKeys: List<MovieRemoteKeys>)

    @Query("DELETE FROM movie_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}