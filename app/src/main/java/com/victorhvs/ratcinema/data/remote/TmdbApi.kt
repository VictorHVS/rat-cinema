package com.victorhvs.ratcinema.data.remote

import com.victorhvs.ratcinema.domain.model.ApiResponse
import com.victorhvs.ratcinema.domain.model.Movie
import retrofit2.http.GET
import retrofit2.http.Query


interface TmdbApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1
    ): ApiResponse<Movie>
}