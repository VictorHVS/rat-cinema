package com.victorhvs.ratcinema.presentation.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.victorhvs.ratcinema.navigation.Screen
import com.victorhvs.ratcinema.presentation.common.MovieList


@ExperimentalCoilApi
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val allMovies = homeViewModel.getAllMovies.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(
                onSearchClicked = {
                    navController.navigate(Screen.Search.route)
                },
                onProfileClicked = {

                }
            )
        },
        content = {
            MovieList(
                movies = allMovies,
                navController = navController
            )
        }
    )
}