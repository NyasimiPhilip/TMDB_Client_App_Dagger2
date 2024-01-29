package com.example.tmdb_client_app.data.repository.tvShow.dataSourceimpl

import com.example.tmdb_client_app.data.db.TvShowDao
import com.example.tmdb_client_app.data.model.tvShow.TvShow
import com.example.tmdb_client_app.data.repository.tvShow.dataSource.TvShowLocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Implementation of [TvShowLocalDataSource] responsible for local database operations related to TV shows.
 *
 * @property tvShowDao Data Access Object for TV show-related database operations.
 */
class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao):
    TvShowLocalDataSource {

    /**
     * Retrieve TV shows from the local database.
     *
     * @return List of TV shows stored in the local database.
     */
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    /**
     * Save a list of TV shows to the local database.
     *
     * @param tvShows List of TV shows to be saved.
     */
    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        withContext(Dispatchers.IO) {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    /**
     * Clear all TV shows from the local database.
     */
    override suspend fun clearAll() {
        withContext(Dispatchers.IO) {
            tvShowDao.deleteAllTvShows()
        }
    }
}
