package com.example.tmdb_client_app.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.domain.usecase.GetMoviesUseCase
import com.example.tmdb_client_app.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies(): LiveData<List<Movie>?> = liveData{
        val movieList: List<Movie>? = getMoviesUseCase.execute()
        emit(movieList)
    }
    fun updateMovies(): LiveData<List<Movie>?> = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }

}