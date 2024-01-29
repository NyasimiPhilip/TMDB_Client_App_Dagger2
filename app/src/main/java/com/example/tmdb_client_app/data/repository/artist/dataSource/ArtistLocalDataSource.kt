package com.example.tmdb_client_app.data.repository.artist.dataSource

import com.example.tmdb_client_app.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}
