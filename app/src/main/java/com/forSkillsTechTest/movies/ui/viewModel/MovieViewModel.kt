package com.forSkillsTechTest.movies.ui.viewModel

// MovieViewModel.kt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel@Inject constructor(val repository: MovieRepository) : ViewModel() {

    private val _popularMovies = MutableStateFlow<List<Movie>>(emptyList())
    val popularMovies: StateFlow<List<Movie>> = _popularMovies

    fun getPopularMovies() {
        viewModelScope.launch {
            _popularMovies.value = repository.getPopularMovies()
        }
    }
}
