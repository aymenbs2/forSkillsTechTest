package com.forSkillsTechTest.movies.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.forSkillsTechTest.movies.R
import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.ui.molecule.MovieItem
import com.forSkillsTechTest.movies.ui.theme.Gray
import com.forSkillsTechTest.movies.ui.viewModel.MovieViewModel

@Composable
fun MovieListScreen(movieViewModel: MovieViewModel = viewModel()) {
    val movies = movieViewModel.popularMovies.collectAsState() // Assuming you have a LiveData or State in your ViewModel

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.popular_movies) , color = Color.Black) },
                backgroundColor = Gray
            )
        },
        content = {padding->

            MovieListContent(modifier=Modifier.padding(padding).background(Gray),movies = movies.value)
        }
    )
}

@Composable
fun MovieListContent( modifier: Modifier,movies: List<Movie>) {
    LazyColumn(modifier) {
        items(movies) { movie ->
            MovieItem(movie = movie) {

            }
        }
    }
}


