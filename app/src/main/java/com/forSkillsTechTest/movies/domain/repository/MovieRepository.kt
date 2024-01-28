package com.forSkillsTechTest.movies.domain.repository

import com.forSkillsTechTest.movies.domain.model.Cast
import com.forSkillsTechTest.movies.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getMovieCast(movieId:Int): List<Cast>

}