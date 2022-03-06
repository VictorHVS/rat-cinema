package com.victorhvs.ratcinema.domain.repository

import androidx.paging.PagingData
import com.victorhvs.ratcinema.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllMovies(): Flow<PagingData<Movie>>
    fun searchMovies(query: String): Flow<PagingData<Movie>>
}