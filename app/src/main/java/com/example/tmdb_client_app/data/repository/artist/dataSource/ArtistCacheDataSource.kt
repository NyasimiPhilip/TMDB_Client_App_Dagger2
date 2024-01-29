package com.example.tmdb_client_app.data.repository.artist.dataSource

import com.example.tmdb_client_app.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)

}