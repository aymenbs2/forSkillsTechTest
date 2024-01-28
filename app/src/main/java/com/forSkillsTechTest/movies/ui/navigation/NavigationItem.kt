package com.forSkillsTechTest.movies.ui.navigation

sealed class NavigationItem(val route: String) {
    object PopularMovies : NavigationItem(Screen.POPULAR_MOVIES.name)
    object MovieDetails : NavigationItem(Screen.MOVIE_DETAILS.name)
}