package com.forSkillsTechTest.movies.di

import com.forSkillsTechTest.movies.domain.datasource.RemoteMoviesDataSource
import com.forSkillsTechTest.movies.domain.repository.MovieRepository
import com.forSkillsTechTest.movies.domain.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideMovieRepository(remoteDataSource: RemoteMoviesDataSource): MovieRepository {
        return MovieRepositoryImpl(remoteDataSource)
    }

}