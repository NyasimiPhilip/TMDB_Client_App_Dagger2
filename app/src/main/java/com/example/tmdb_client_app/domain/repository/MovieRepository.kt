package com.example.tmdb_client_app.domain.repository

import com.example.tmdb_client_app.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}