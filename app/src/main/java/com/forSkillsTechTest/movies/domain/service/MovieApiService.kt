package com.forSkillsTechTest.movies.domain.service

import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.domain.model.MoviesPage
import retrofit2.http.GET

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): MoviesPage
}