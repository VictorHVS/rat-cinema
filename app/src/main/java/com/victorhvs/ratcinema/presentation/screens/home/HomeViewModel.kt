package com.victorhvs.ratcinema.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.victorhvs.ratcinema.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val getAllMovies = repository.getAllMovies()
}