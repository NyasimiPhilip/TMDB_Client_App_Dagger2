package com.example.tmdb_client_app.domain.usecase

import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}