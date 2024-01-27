package com.forSkillsTechTest.movies.domain.repository

import com.forSkillsTechTest.movies.domain.datasource.RemoteMovieDataSourceImpl
import com.forSkillsTechTest.movies.domain.datasource.RemoteMoviesDataSource
import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.domain.model.MoviesPage
import com.forSkillsTechTest.movies.domain.service.MovieApiService
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryTest {

    @Mock
    private lateinit var movieApiService: MovieApiService

    private lateinit var remoteMovieDataSource: RemoteMoviesDataSource

    private lateinit var movieRepository: MovieRepository

    @Before
    fun setup() {
        remoteMovieDataSource = RemoteMovieDataSourceImpl(movieApiService)
        movieRepository = MovieRepositoryImpl(remoteMovieDataSource)
    }

    @Test
    fun `getPopularMovies returns a page of movies`() = runBlocking {
        // Given
        val mockMovies: List<Movie> = arrayListOf(
            Movie(id = 787699, title = "Wonka", posterPath = "/qhb1qOilapbapxWQn9jtRCMwXJF.jpg", voteAverage = 7.193),
            Movie(id = 572802, title = "Aquaman and the Lost Kingdom", posterPath = "/7lTnXOy0iNtBAdRP3TZvaKJ77F6.jpg", voteAverage = 6.836),
        )
        val moviesPage=MoviesPage(page = 1, totalPages = 42480, totalResults = 849585, results = mockMovies)
        // Mock API response
        `when`(movieApiService.getPopularMovies()).thenReturn(moviesPage)

        // When
        val result = movieRepository.getPopularMovies()
        // Then
        assert(result == mockMovies)
    }

}
