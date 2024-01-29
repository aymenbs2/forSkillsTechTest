package com.forSkillsTechTest.movies.domain.repository

import com.forSkillsTechTest.movies.domain.datasource.RemoteMoviesDataSource


class MovieRepositoryImpl(private val remoteDataSource: RemoteMoviesDataSource) : MovieRepository {
    override suspend fun getPopularMovies() = remoteDataSource.getPopularMovies()


    override suspend fun getMovieCast(movieId: Int) = remoteDataSource.getMovieCast(movieId)

}