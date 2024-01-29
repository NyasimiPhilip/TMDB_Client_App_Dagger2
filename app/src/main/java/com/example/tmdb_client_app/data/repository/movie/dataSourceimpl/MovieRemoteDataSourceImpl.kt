package com.example.tmdb_client_app.data.repository.movie.dataSourceimpl

import com.example.tmdb_client_app.data.api.TMDBService
import com.example.tmdb_client_app.data.model.movie.MovieList
import com.example.tmdb_client_app.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response

/**
 * Implementation of [MovieRemoteDataSource] responsible for fetching movie data from a remote API.
 *
 * @property tmdbService Service interface for TMDB API communication.
 * @property apiKey The API key used for authenticating requests to the TMDB API.
 */
class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {

    /**
     * Fetch popular movies from the remote TMDB API.
     *
     * @return Response object containing a [MovieList] if the request is successful.
     */
    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)
}
