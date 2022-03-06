package com.victorhvs.ratcinema.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.victorhvs.ratcinema.data.remote.TmdbApi
import com.victorhvs.ratcinema.domain.model.Movie

class SearchMovieSource(
    private val tmdbApi: TmdbApi,
    private val query: String
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val apiResponse = tmdbApi.searchMovies(query = query, page = params.key ?: 1)
            val movies = apiResponse.results
            if (movies.isNotEmpty()) {
                LoadResult.Page(
                    data = movies,
                    prevKey = if (apiResponse.page == 1) null else apiResponse.page - 1,
                    nextKey = if (apiResponse.totalPages == apiResponse.page) null else apiResponse.page + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}