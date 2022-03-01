package com.victorhvs.ratcinema.presentation.common

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.gowtham.ratingbar.RatingBar
import com.victorhvs.ratcinema.R
import com.victorhvs.ratcinema.domain.model.Movie
import com.victorhvs.ratcinema.navigation.Screen
import com.victorhvs.ratcinema.ui.theme.*

@ExperimentalCoilApi
@Composable
fun MovieList(
    movies: LazyPagingItems<Movie>,
    navController: NavHostController
) {
    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(
            items = movies,
            key = { movie ->
                movie.id
            }
        ) { hero ->
            hero?.let {
                MovieItem(movie = it, navController = navController)
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun MovieItem(
    movie: Movie,
    navController: NavHostController
) {
    val painter =
        rememberImagePainter(data = "https://image.tmdb.org/t/p/w780${movie.backdropPath}") {
            placeholder(R.drawable.ic_placeholder)
            error(R.drawable.ic_placeholder)
        }

    Box(
        modifier = Modifier
            .height(MOVIE_ITEM_HEIGHT)
            .clickable {
                navController.navigate(Screen.Details.passMovieId(movieId = movie.id))
            },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(shape = RoundedCornerShape(size = LARGE_PADDING)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = stringResource(R.string.movie_image),
                contentScale = ContentScale.Crop
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = MEDIUM_PADDING)
            ) {
                Text(
                    text = movie.title,
                    color = Color.White,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = movie.overview,
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.padding(top = SMALL_PADDING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val voteAverage = movie.voteAverage.toFloat() / 2
                    RatingBar(
                        value = voteAverage,
                        onValueChange = {},
                        onRatingChanged = {},
                        isIndicator = true,
                        numStars = 5,
                        size = 12.dp,
                        activeColor = ratingBarActive,
                        inactiveColor = ratingBarInactive,
                        modifier = Modifier.padding(end = SMALL_PADDING)
                    )
                    Text(
                        text = "($voteAverage)",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium)
                    )
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
@Preview
fun MovieItemPreview() {
    MovieItem(
        movie = Movie(
            id = 634649,
            adult = false,
            backdropPath = "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg",
            genreIds = emptyList(),
            originalLanguage = "en",
            originalTitle = "Spider-Man: No Way Home",
            overview = "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
            popularity = 7517.432,
            posterPath = "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            releaseDate = "2021-12-15",
            title = "Spider-Man: No Way Home",
            video = false,
            voteAverage = 8.3,
            voteCount = 8460
        ),
        navController = rememberNavController()
    )
}

@ExperimentalCoilApi
@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun MovieItemDarkPreview() {
    MovieItem(
        movie = Movie(
            id = 634649,
            adult = false,
            backdropPath = "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg",
            genreIds = emptyList(),
            originalLanguage = "en",
            originalTitle = "Spider-Man: No Way Home",
            overview = "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
            popularity = 7517.432,
            posterPath = "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            releaseDate = "2021-12-15",
            title = "Spider-Man: No Way Home",
            video = false,
            voteAverage = 8.3,
            voteCount = 8460
        ),
        navController = rememberNavController()
    )
}