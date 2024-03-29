package com.forSkillsTechTest.movies.domain.datasource

import com.forSkillsTechTest.movies.domain.model.Cast
import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.domain.service.MovieApiService

class RemoteMovieDataSourceImpl(private val movieApiService: MovieApiService) :RemoteMoviesDataSource {
    override suspend fun getPopularMovies(): List<Movie> {
      return  movieApiService.getPopularMovies().results
    }

    override suspend fun getMovieCast(movieId:Int): List<Cast> {
        return  movieApiService.getMovieCast(movieId).cast
    }
}