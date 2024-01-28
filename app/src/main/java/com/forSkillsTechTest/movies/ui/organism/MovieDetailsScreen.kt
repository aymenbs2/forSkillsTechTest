package com.forSkillsTechTest.movies.ui.organism

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.forSkillsTechTest.movies.BuildConfig
import com.forSkillsTechTest.movies.R
import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.ui.atom.ImageBottomCentredTitle
import com.forSkillsTechTest.movies.ui.atom.Synopsis
import com.forSkillsTechTest.movies.ui.molecule.Actors
import com.forSkillsTechTest.movies.ui.theme.Blue
import com.forSkillsTechTest.movies.ui.viewModel.MovieViewModel

@Composable
fun MovieDetailsScreen(navController: NavHostController, movie: Movie) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                title = {
                    NavigateBack(stringResource(id = R.string.popular_movies)) {
                        navController.popBackStack()
                    }
                },
                backgroundColor = Color.White
            )
        },
        content = { padding ->

            MovieDetailsContent(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(), movie = movie
            )
        }
    )
}

@Composable
fun NavigateBack(text: String, onClick: () -> Boolean) {
    Row(modifier = Modifier.clickable {
        onClick()
    }) {
        Image(
            modifier = Modifier.size(25.dp),
            painter = painterResource(id = R.drawable.ic_back_arrow_icon),
            colorFilter = ColorFilter.tint(Blue),
            contentDescription = null
        )
        Text(
            text = text,
            color = Blue
        )
    }
}

@Composable
fun MovieDetailsContent(modifier: Modifier, movie: Movie) {
    val viewModel: MovieViewModel = hiltViewModel()
    SideEffect {
        movie.id?.let { viewModel.getMovieCast(movieId = it) }

    }
    Column(modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        ImageBottomCentredTitle(path = "${BuildConfig.IMAGES_BASE_URL}${movie.backdropPath}", title = movie.title?:"")
        Spacer(modifier = Modifier.height(10.dp))
        Synopsis(modifier = Modifier.padding(10.dp), movie.overview)
        Actors(
            modifier = Modifier.padding(15.dp),
            castsState = viewModel.movieCast.collectAsState()
        )
    }
}




