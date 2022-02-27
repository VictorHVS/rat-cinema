package com.victorhvs.ratcinema.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.victorhvs.ratcinema.util.Constants.MOVIE_DATABASE_TABLE

@Entity(tableName = MOVIE_DATABASE_TABLE)
data class Movie(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)