package com.forSkillsTechTest.movies.domain.datasource

import com.forSkillsTechTest.movies.domain.model.Movie


interface RemoteMoviesDataSource {
    suspend fun getPopularMovies(): List<Movie>

}