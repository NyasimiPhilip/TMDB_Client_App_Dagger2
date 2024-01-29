package com.example.tmdb_client_app.domain.repository

import com.example.tmdb_client_app.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}