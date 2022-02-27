package com.victorhvs.ratcinema.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.victorhvs.ratcinema.util.Constants.MOVIE_REMOTE_KEY_DATABASE_TABLE

@Entity(tableName = MOVIE_REMOTE_KEY_DATABASE_TABLE)
data class MovieRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
