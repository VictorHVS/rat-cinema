package com.victorhvs.ratcinema.presentation.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victorhvs.ratcinema.data.repository.Repository
import com.victorhvs.ratcinema.domain.model.Movie
import com.victorhvs.ratcinema.util.Constants.DETAILS_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    val repository: Repository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _selectedMovie: MutableStateFlow<Movie?> = MutableStateFlow(null)
    val selectedMovie: StateFlow<Movie?> = _selectedMovie

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val movieId = savedStateHandle.get<Int>(DETAILS_ARGUMENT_KEY)
            _selectedMovie.value = movieId?.let { repository.getSelectedMovie(movieId = movieId) }
        }
    }
}