package com.forSkillsTechTest.movies.domain.service

import com.forSkillsTechTest.movies.domain.model.CastPage
import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.domain.model.MoviesPage
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): MoviesPage

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCast(@Path("movie_id") id: Int   ): CastPage
}