package com.example.tmdb_client_app.data.repository.movie.dataSource

import com.example.tmdb_client_app.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}