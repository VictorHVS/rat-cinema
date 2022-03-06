package com.victorhvs.ratcinema.data.remote

import com.victorhvs.ratcinema.domain.model.ApiResponse
import com.victorhvs.ratcinema.domain.model.Movie

class FakeTmdbApi : TmdbApi {

    private val movies = listOf(
        Movie(
            adult = false,
            backdropPath = "/5P8SmMzSNYikXpxil6BYzJ16611.jpg",
            genreIds = listOf(
                28,
                80,
                18
            ),
            id = 414906,
            originalLanguage = "en",
            originalTitle = "The Batman",
            overview = "In his second year of fighting crime, Batman uncovers corruption in Gotham City that connects to his own family while facing a serial killer known as the Riddler.",
            popularity = 4598.244f,
            posterPath = "/74xTEgt7R36Fpooo50r9T25onhq.jpg",
            releaseDate = "2022-03-01",
            title = "The Batman",
            video = false,
            voteAverage = 8.2f,
            voteCount = 666
        ),
        Movie(
            adult = false,
            backdropPath = "/tutaKitJJIaqZPyMz7rxrhb4Yxm.jpg",
            genreIds = listOf(
                16,
                35,
                10751,
                10402
            ),
            id = 438695,
            originalLanguage = "en",
            originalTitle = "Sing 2",
            overview = "Buster and his new cast now have their sights set on debuting a new show at the Crystal Tower Theater in glamorous Redshore City. But with no connections, he and his singers must sneak into the Crystal Entertainment offices, run by the ruthless wolf mogul Jimmy Crystal, where the gang pitches the ridiculous idea of casting the lion rock legend Clay Calloway in their show. Buster must embark on a quest to find the now-isolated Clay and persuade him to return to the stage.",
            popularity = 1458.109f,
            posterPath = "/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",
            releaseDate = "2021-12-01",
            title = "Sing 2",
            video = false,
            voteAverage = 8.2f,
            voteCount = 2115
        ),
        Movie(
            adult = false,
            backdropPath = "/loI63vxJK0UgYSXrzYdxOoCw2YO.jpg",
            genreIds = listOf(
                28,
                12
            ),
            id = 335787,
            originalLanguage = "en",
            originalTitle = "Uncharted",
            overview = "A young street-smart, Nathan Drake and his wisecracking partner Victor “Sully” Sullivan embark on a dangerous pursuit of “the greatest treasure never found” while also tracking clues that may lead to Nathan’s long-lost brother.",
            popularity = 1155.265f,
            posterPath = "/sqLowacltbZLoCa4KYye64RvvdQ.jpg",
            releaseDate = "2022-02-10",
            title = "The Uncharted",
            video = false,
            voteAverage = 7.1f,
            voteCount = 634
        ),
    )

    override suspend fun getUpcoming(page: Int): ApiResponse<Movie> {
        return ApiResponse(
            page = 1,
            totalPages = 1,
            totalResults = 3,
            results = movies
        )
    }

    override suspend fun searchMovies(query: String, page: Int): ApiResponse<Movie> {
        val searchedMovies = findMovies(title = query)
        return ApiResponse(
            page = 1,
            totalPages = 1,
            totalResults = 3,
            results = searchedMovies
        )
    }

    private fun findMovies(title: String): List<Movie> {
        val founded = mutableListOf<Movie>()
        return if (title.isNotEmpty()) {
            movies.forEach { movie ->
                if (movie.title!!.lowercase().contains(title.lowercase())) {
                    founded.add(movie)
                }
            }
            founded
        } else {
            emptyList()
        }
    }
}