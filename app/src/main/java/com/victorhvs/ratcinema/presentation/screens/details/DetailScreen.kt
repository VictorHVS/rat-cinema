package com.victorhvs.ratcinema.presentation.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi

@ExperimentalCoilApi
@Composable
fun DetailsScreen(
    navController: NavHostController,
    detailViewModel: DetailViewModel = hiltViewModel()
) {
    val selectedMovie by detailViewModel.selectedMovie.collectAsState()

    DetailContent(
        navController = navController,
        movie = selectedMovie
    )
}