package com.victorhvs.ratcinema.presentation.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.gowtham.ratingbar.RatingBar
import com.victorhvs.ratcinema.R
import com.victorhvs.ratcinema.domain.model.Movie
import com.victorhvs.ratcinema.ui.theme.SMALL_PADDING
import com.victorhvs.ratcinema.ui.theme.ratingBarActive
import com.victorhvs.ratcinema.ui.theme.ratingBarInactive

@Composable
fun DetailContent(
    navController: NavHostController,
    movie: Movie?
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        Box {
            Image(
                painter = rememberImagePainter(data = "https://image.tmdb.org/t/p/w780${movie?.posterPath}"),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 3.0f.div(4.0f)),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back button",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(12.dp),
                    tint = Color.White
                )
            }
        }
        Column(
            modifier = Modifier.padding(start = SMALL_PADDING, end = 8.dp)
        ) {
            Text(
                movie?.title ?: "",
                style = MaterialTheme.typography.h4.copy(MaterialTheme.colors.onSurface),
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
            )
            Row(
                modifier = Modifier.padding(top = SMALL_PADDING),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RatingBar(
                    value = movie?.display5StarsRating() ?: 0f,
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
                    text = "(${movie?.voteCount} votes)",
                    textAlign = TextAlign.Center,
                    color = Color.White.copy(alpha = ContentAlpha.medium)
                )
            }
            Text(
                movie?.releaseDate ?: "",
                style = MaterialTheme.typography.caption.copy(color = Color.Gray),
                modifier = Modifier.padding(top = 8.dp)
            )
            if (!movie?.overview.isNullOrBlank()) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(id = R.string.title_overview),
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = movie?.overview ?: "",
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = MaterialTheme.colors.onSurface
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
@Preview
fun DetailContentPreview() {
    DetailContent(
        movie = Movie(
            id = 634649,
            adult = false,
            backdropPath = "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            genreIds = emptyList(),
            originalLanguage = "en",
            originalTitle = "Spider-Man: No Way Home",
            overview = "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
            popularity = 7517.432f,
            posterPath = "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            releaseDate = "2021-12-15",
            title = "Spider-Man: No Way Home",
            video = false,
            voteAverage = 8.3f,
            voteCount = 8460
        ),
        navController = rememberNavController()
    )
}