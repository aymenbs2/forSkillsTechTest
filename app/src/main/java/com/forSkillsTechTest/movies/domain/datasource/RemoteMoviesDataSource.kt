package com.forSkillsTechTest.movies.domain.datasource

import com.forSkillsTechTest.movies.domain.model.Cast
import com.forSkillsTechTest.movies.domain.model.Movie


interface RemoteMoviesDataSource {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getMovieCast(movieId:Int): List<Cast>

}