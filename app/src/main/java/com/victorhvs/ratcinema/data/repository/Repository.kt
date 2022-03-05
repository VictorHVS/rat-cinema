package com.victorhvs.ratcinema.data.repository

import androidx.paging.PagingData
import com.victorhvs.ratcinema.domain.model.Movie
import com.victorhvs.ratcinema.domain.repository.LocalDataSource
import com.victorhvs.ratcinema.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
) {

    fun getAllMovies(): Flow<PagingData<Movie>> {
        return remote.getAllMovies()
    }

    suspend fun getSelectedMovie(movieId: Int): Movie {
        return local.getSelectedMovie(movieId = movieId)
    }

    suspend fun searchMovies(query: String): Flow<List<Movie>> {
        return remote.searchMovies(query = query)
    }
}