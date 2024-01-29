package com.example.tmdb_client_app.data.repository.movie.dataSourceimpl

import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.data.repository.movie.dataSource.MovieCacheDataSource

/**
 * Implementation of [MovieCacheDataSource] responsible for caching movie data.
 */
class MovieCacheDataSourceImpl : MovieCacheDataSource {

    // In-memory storage for the list of movies
    private var movieList = ArrayList<Movie>()

    /**
     * Retrieve movies from the cache.
     *
     * @return List of movies if available in the cache, otherwise an empty list.
     */
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    /**
     * Save a list of movies to the cache.
     *
     * @param movies The list of movies to be saved to the cache.
     */
    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        // Clear the existing list and replace it with the new list of movies
        movieList.clear()
        movieList = ArrayList(movies)
    }
}
