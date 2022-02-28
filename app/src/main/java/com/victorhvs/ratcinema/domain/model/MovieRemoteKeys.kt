package com.victorhvs.ratcinema.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.victorhvs.ratcinema.util.Constants.MOVIE_REMOTE_KEYS_DATABASE_TABLE

@Entity(tableName = MOVIE_REMOTE_KEYS_DATABASE_TABLE)
data class MovieRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
