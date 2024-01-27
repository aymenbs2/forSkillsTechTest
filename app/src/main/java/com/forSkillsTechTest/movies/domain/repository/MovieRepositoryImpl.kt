package com.forSkillsTechTest.movies.domain.repository

import com.forSkillsTechTest.movies.domain.datasource.RemoteMoviesDataSource
import com.forSkillsTechTest.movies.domain.model.Movie

class MovieRepositoryImpl(private val remoteDataSource: RemoteMoviesDataSource):MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
      return  remoteDataSource.getPopularMovies()
    }
}