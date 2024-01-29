package com.forSkillsTechTest.movies.ui.organism

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.forSkillsTechTest.movies.R
import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.ui.molecule.MovieItem
import com.forSkillsTechTest.movies.ui.molecule.SearchBar
import com.forSkillsTechTest.movies.ui.navigation.NavigationItem
import com.forSkillsTechTest.movies.ui.theme.Gray
import com.forSkillsTechTest.movies.ui.viewModel.MovieViewModel
import com.forSkillsTechTest.movies.util.JsonUtils

@Composable
fun PopularMovieListScreen(navHostController: NavHostController) {
    val viewModel = hiltViewModel<MovieViewModel>()
    DisposableEffect(Unit) {
        viewModel.getPopularMovies()
        onDispose { }
    }
    val movies by viewModel.popularMovies.collectAsState()

    val isSearchMode = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Scaffold(
        modifier = Modifier.clickable {
            focusManager.clearFocus()
        },
        topBar = {
            if (!isSearchMode.value) {
                TopAppBar(
                    elevation = 0.dp,
                    title = {

                        Text(
                            modifier = Modifier.padding(top = 30.dp),
                            text = stringResource(id = R.string.popular_movies),
                            color = Color.Black
                        )
                    },
                    backgroundColor = Gray
                )
            }
        },
        content = { padding ->
            PopularMovieListContent(
                navHostController = navHostController,
                modifier = Modifier
                    .padding(padding)
                    .background(Gray),
                movies = movies,
                isSearchMode = isSearchMode
            )
        }
    )
}

@Composable
fun PopularMovieListContent(
    navHostController: NavHostController,
    modifier: Modifier,
    movies: List<Movie>,
    isSearchMode: MutableState<Boolean>
) {
    var query by remember { mutableStateOf("") }
    var filteredList by remember { mutableStateOf(movies) }

    DisposableEffect(query) {
        filteredList = if (query.isNotBlank()) {
            movies.filter { movie ->
                movie.title?.lowercase()?.contains(query.lowercase()) == true ||
                        movie.originalTitle?.lowercase()?.contains(query.lowercase()) == true
            }
        } else {
            movies
        }
        onDispose { /* cleanup logic if needed */ }
    }

    Column(modifier) {
        SearchBar(
            modifier = Modifier.padding(top = 10.dp),
            isFocused = isSearchMode,
            onQueryChange = { query = it }
        ) {
            isSearchMode.value = it
        }
        MovieListContent(navHostController = navHostController, movies = if(filteredList.isEmpty() && query.isNullOrEmpty())movies else filteredList)
    }
}


@Composable
fun MovieListContent(
    navHostController: NavHostController,
    movies: List<Movie>
) {
    LazyColumn {
        items(movies) { movie ->
            MovieItem(movie = movie) {
                navHostController.navigate(
                    NavigationItem.MovieDetails.route + "/${
                        Uri.encode(
                            JsonUtils.toJson(movie)
                        )
                    }"
                )
            }
        }
    }
}
