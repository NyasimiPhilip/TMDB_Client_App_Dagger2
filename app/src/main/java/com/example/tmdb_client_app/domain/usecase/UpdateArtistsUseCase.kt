package com.example.tmdb_client_app.domain.usecase

import com.example.tmdb_client_app.data.model.artist.Artist
import com.example.tmdb_client_app.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}