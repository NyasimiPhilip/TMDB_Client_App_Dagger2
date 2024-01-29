package com.example.tmdb_client_app.data.repository.artist.dataSourceimpl

import com.example.tmdb_client_app.data.db.ArtistDao
import com.example.tmdb_client_app.data.model.artist.Artist
import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.data.repository.artist.dataSource.ArtistLocalDataSource
import com.example.tmdb_client_app.data.repository.movie.dataSource.MovieLocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Implementation of [ArtistLocalDataSource] responsible for local database operations related to artists
 *
 * @property artistDao Data Access Object for artist-related database operations.
 */
class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {

    /**
     * Retrieve artists from the local database.
     *
     * @return List of artists stored in the local database.
     */
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    /**
     * Save a list of artists to the local database.
     *
     * @param artists List of movies to be saved.
     */
    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        withContext(Dispatchers.IO) {
            artistDao.saveArtists(artists)
        }
    }

    /**
     * Clear all artists from the local database.
     */
    override suspend fun clearAll() {
        withContext(Dispatchers.IO) {
            artistDao.deleteAllArtists()
        }
    }
}
