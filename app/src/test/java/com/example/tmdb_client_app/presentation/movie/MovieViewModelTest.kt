package com.example.tmdb_client_app.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.data.repository.movie.FakeMovieRepository
import com.example.tmdb_client_app.domain.usecase.GetMoviesUseCase
import com.example.tmdb_client_app.domain.usecase.UpdateMoviesUseCase
import com.example.tmdb_client_app.getOrAwaitValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import com.google.common.truth.Truth.assertThat
import org.junit.Test
@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel
    @Before
    fun setup(){

        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)

        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }
    @Test
    fun getMovies_returnsCurrentList(){
        val movies = mutableListOf<Movie>()
        movies.add( Movie(1, "overview1", "posterPath1", "date1", "title1"))
        movies.add(Movie(2, "overview2", "posterPath2", "date2", "title2"))

        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }
    @Test
    fun updateMovies_returnsUpdatedList(){
        val movies = mutableListOf<Movie>()
        movies.add( Movie(3, "overview3", "posterPath3", "date3", "title3"))
        movies.add(Movie(4, "overview4", "posterPath4", "date4", "title4"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }

}