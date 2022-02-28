package com.victorhvs.ratcinema.data.repository

import androidx.paging.PagingData
import com.victorhvs.ratcinema.domain.model.Movie
import com.victorhvs.ratcinema.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource
) {

    fun getAllMovies(): Flow<PagingData<Movie>> {
        return remote.getAllMovies()
    }
}