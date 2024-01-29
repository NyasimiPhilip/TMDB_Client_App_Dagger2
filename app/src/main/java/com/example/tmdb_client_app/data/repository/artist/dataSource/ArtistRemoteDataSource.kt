package com.example.tmdb_client_app.data.repository.artist.dataSource

import com.example.tmdb_client_app.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}