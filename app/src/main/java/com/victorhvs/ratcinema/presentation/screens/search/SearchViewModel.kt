package com.victorhvs.ratcinema.presentation.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.victorhvs.ratcinema.data.repository.Repository
import com.victorhvs.ratcinema.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _searchedMovies = MutableStateFlow<List<Movie>>(emptyList())
    val searchedMovies = _searchedMovies

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun searchMovies(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.searchMovies(query = query).collect {
                _searchedMovies.value = it
            }
        }
    }
}