package com.forSkillsTechTest.movies.di

import com.forSkillsTechTest.movies.domain.datasource.RemoteMovieDataSourceImpl
import com.forSkillsTechTest.movies.domain.datasource.RemoteMoviesDataSource
import com.forSkillsTechTest.movies.domain.service.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RemoteMovieDataSourceModule {

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(movieApiService: MovieApiService): RemoteMoviesDataSource{
        return RemoteMovieDataSourceImpl(movieApiService)
    }
}