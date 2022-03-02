package com.victorhvs.ratcinema.domain.repository

import com.victorhvs.ratcinema.domain.model.Movie

interface LocalDataSource {
    suspend fun getSelectedMovie(movieId: Int): Movie
}