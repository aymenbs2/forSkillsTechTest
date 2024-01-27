package com.forSkillsTechTest.movies.di

import com.forSkillsTechTest.movies.domain.repository.MovieRepository
import com.forSkillsTechTest.movies.ui.viewModel.MovieViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object HiltViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideMovieViewModel(repository: MovieRepository): MovieViewModel {
        return MovieViewModel(repository)
    }
}
