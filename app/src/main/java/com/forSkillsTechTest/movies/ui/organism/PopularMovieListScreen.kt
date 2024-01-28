package com.forSkillsTechTest.movies.ui.organism

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.forSkillsTechTest.movies.R
import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.ui.molecule.MovieItem
import com.forSkillsTechTest.movies.ui.navigation.NavigationItem
import com.forSkillsTechTest.movies.ui.theme.Gray
import com.forSkillsTechTest.movies.ui.viewModel.MovieViewModel
import com.forSkillsTechTest.movies.util.JsonUtils

@Composable
fun PopularMovieListScreen(navHostController: NavHostController ) {
    val viewModel= hiltViewModel<MovieViewModel>()
    SideEffect {
        viewModel.getPopularMovies()
    }
    val movies = viewModel.popularMovies.collectAsState() // Assuming you have a LiveData or State in your ViewModel

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.popular_movies) , color = Color.Black) },
                backgroundColor = Gray
            )
        },
        content = {padding->
            MovieListContent(navHostController=navHostController,modifier= Modifier
                .padding(padding)
                .background(Gray),movies = movies.value)
        }
    )
}

@Composable
fun MovieListContent(navHostController: NavHostController, modifier: Modifier, movies: List<Movie>) {
    LazyColumn(modifier) {
        items(movies,) { movie ->
            MovieItem(movie = movie) {
                navHostController.navigate(NavigationItem.MovieDetails.route+"/${Uri.encode(JsonUtils.toJson(movie))}")
            }
        }
    }
}


