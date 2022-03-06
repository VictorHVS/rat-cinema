package com.victorhvs.ratcinema.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.victorhvs.ratcinema.data.local.RatCinemaDatabase
import com.victorhvs.ratcinema.data.paging_source.MovieRemoteMediator
import com.victorhvs.ratcinema.data.paging_source.SearchMovieSource
import com.victorhvs.ratcinema.data.remote.TmdbApi
import com.victorhvs.ratcinema.domain.model.Movie
import com.victorhvs.ratcinema.domain.repository.RemoteDataSource
import com.victorhvs.ratcinema.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val tmdbApi: TmdbApi,
    private val ratCinemaDatabase: RatCinemaDatabase
) : RemoteDataSource {

    private val movieDao = ratCinemaDatabase.movieDao()

    override fun getAllMovies(): Flow<PagingData<Movie>> {
        val pagingSourceFactory = { movieDao.getAllMovies() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = MovieRemoteMediator(
                tmdbApi = tmdbApi,
                ratCinemaDatabase = ratCinemaDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchMovies(query: String): Flow<PagingData<Movie>> {
//        return withContext(Dispatchers.IO) {
//            flow {
//                emit(tmdbApi.searchMovies(query = query).results)
//            }
//        }
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchMovieSource(tmdbApi = tmdbApi, query = query)
            }
        ).flow
    }

}