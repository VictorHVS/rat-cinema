package com.victorhvs.ratcinema.data.repository

import com.victorhvs.ratcinema.data.local.RatCinemaDatabase
import com.victorhvs.ratcinema.data.local.dao.MovieDao
import com.victorhvs.ratcinema.domain.model.Movie
import com.victorhvs.ratcinema.domain.repository.LocalDataSource

class LocalDataSourceImpl(ratCinemaDatabase: RatCinemaDatabase) : LocalDataSource {

    private val movieDao: MovieDao = ratCinemaDatabase.movieDao()

    override suspend fun getSelectedMovie(movieId: Int): Movie {
        return movieDao.getSelectedMovie(movieId)
    }
}