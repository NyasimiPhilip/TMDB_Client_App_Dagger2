package com.example.tmdb_client_app.data.repository.artist.dataSourceimpl

import com.example.tmdb_client_app.data.model.artist.Artist
import com.example.tmdb_client_app.data.repository.artist.dataSource.ArtistCacheDataSource

/**
 * Implementation of [ArtistCacheDataSource] responsible for caching artist data.
 */
class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    // In-memory storage for the list of artists
    private var artistList = ArrayList<Artist>()

    /**
     * Retrieve artists from the cache.
     *
     * @return List of artists if available in the cache, otherwise an empty list.
     */
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    /**
     * Save a list of artists to the cache.
     *
     * @param artists The list of artists to be saved to the cache.
     */
    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        // Clear the existing list and replace it with the new list of artists
        artistList.clear()
        artistList = ArrayList(artists)
    }
}
