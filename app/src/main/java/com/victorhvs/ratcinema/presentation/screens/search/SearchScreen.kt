package com.victorhvs.ratcinema.presentation.screens.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.victorhvs.ratcinema.presentation.common.MovieList

@ExperimentalCoilApi
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    val searchQuery by searchViewModel.searchQuery
    val movies = searchViewModel.searchedMovies.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            SearchTopBar(
                text = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(query = it)
                },
                onSearchClicked = {
                    searchViewModel.searchMovies(query = it)
                },
                onCloseClicked = {
                    navController.popBackStack()
                }
            )
        },
        content = {
            MovieList(
                movies = movies,
                navController = navController
            )
//            LazyColumn(
//                contentPadding = PaddingValues(all = SMALL_PADDING),
//                verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
//            ) {
//                items(movies.value) {
//                    MovieItem(movie = it, navController = navController)
//                }
//            }
        }
    )
}