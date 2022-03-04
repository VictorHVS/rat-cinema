package com.victorhvs.ratcinema.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.victorhvs.ratcinema.data.local.RatCinemaDatabase
import com.victorhvs.ratcinema.data.remote.TmdbApi
import com.victorhvs.ratcinema.domain.model.Movie
import com.victorhvs.ratcinema.domain.model.MovieRemoteKeys
import javax.inject.Inject

@ExperimentalPagingApi
class MovieRemoteMediator(
    private val tmdbApi: TmdbApi,
    private val ratCinemaDatabase: RatCinemaDatabase
): RemoteMediator<Int, Movie>() {

    private val movieDao = ratCinemaDatabase.movieDao()
    private val movieRemoteKeysDao = ratCinemaDatabase.movieRemoteKeysDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Movie>): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }

            val response = tmdbApi.getUpcoming(page = page)
            if (response.results.isNotEmpty()) {
                ratCinemaDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        movieDao.deleteAllMovies()
                        movieRemoteKeysDao.deleteAllRemoteKeys()
                    }
                    val prevPage = if (response.page == 1) null else response.page - 1
                    val nextPage = response.page + 1
                    val keys = response.results.map { movie ->
                        MovieRemoteKeys(
                            id = movie.id,
                            prevPage = prevPage,
                            nextPage = nextPage
                        )
                    }
                    movieRemoteKeysDao.addAllRemoteKeys(movieRemoteKeys = keys)
                    movieDao.addMovies(movies = response.results)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.page == response.totalPages)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, Movie>
    ): MovieRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                movieRemoteKeysDao.getRemoteKeys(movieId = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, Movie>
    ): MovieRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { movie ->
                movieRemoteKeysDao.getRemoteKeys(movieId = movie.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, Movie>
    ): MovieRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { movie ->
                movieRemoteKeysDao.getRemoteKeys(movieId = movie.id)
            }
    }

}