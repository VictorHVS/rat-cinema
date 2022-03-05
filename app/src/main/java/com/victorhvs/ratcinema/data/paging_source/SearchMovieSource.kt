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
            val apiResponse = tmdbApi.searchMovies(query = query)
            val movies = apiResponse.results
            if (movies.isNotEmpty()) {
                LoadResult.Page(
                    data = movies,
                    prevKey = if (apiResponse.page == 1) 1 else apiResponse.page - 1,
                    nextKey = apiResponse.page + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}