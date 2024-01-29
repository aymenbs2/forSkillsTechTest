package com.forSkillsTechTest.movies.ui.molecule


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.ui.navigation.NavigationItem
import com.forSkillsTechTest.movies.ui.organism.MovieDetailsScreen
import com.forSkillsTechTest.movies.ui.organism.PopularMovieListScreen
import com.forSkillsTechTest.movies.util.Constants.Companion.MOVIE_KEY
import com.forSkillsTechTest.movies.util.JsonUtils

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = NavigationItem.PopularMovies.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.PopularMovies.route) {
            PopularMovieListScreen(navController)
        }
        composable(NavigationItem.MovieDetails.route+"/{$MOVIE_KEY}",
            arguments = listOf(navArgument(MOVIE_KEY) {
            type = NavType.StringType
        })) { backStackEntry ->
            val movie = backStackEntry.arguments?.getString(MOVIE_KEY)
                ?.let { JsonUtils.fromJson<Movie>(it) }
            movie?.let {
                MovieDetailsScreen(navController, it)
            } ?: run {
                println("no movie")
            }
        }
    }
}