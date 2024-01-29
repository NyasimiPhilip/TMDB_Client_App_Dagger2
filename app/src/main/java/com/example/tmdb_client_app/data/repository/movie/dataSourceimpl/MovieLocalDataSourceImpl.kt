package com.example.tmdb_client_app.data.repository.movie.dataSourceimpl

import com.example.tmdb_client_app.data.db.MovieDao
import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.data.repository.movie.dataSource.MovieLocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Implementation of [MovieLocalDataSource] responsible for local database operations related to movies.
 *
 * @property movieDao Data Access Object for movie-related database operations.
 */
class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {

    /**
     * Retrieve movies from the local database.
     *
     * @return List of movies stored in the local database.
     */
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    /**
     * Save a list of movies to the local database.
     *
     * @param movies List of movies to be saved.
     */
    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        withContext(Dispatchers.IO) {
            movieDao.saveMovies(movies)
        }
    }

    /**
     * Clear all movies from the local database.
     */
    override suspend fun clearAll() {
        withContext(Dispatchers.IO) {
            movieDao.deleteAllMovies()
        }
    }
}
