package com.example.tmdb_client_app.data.repository.artist.dataSourceimpl

import com.example.tmdb_client_app.data.api.TMDBService
import com.example.tmdb_client_app.data.model.artist.ArtistList
import com.example.tmdb_client_app.data.repository.artist.dataSource.ArtistRemoteDataSource
import retrofit2.Response

/**
 * Implementation of [ArtistRemoteDataSource] responsible for fetching artist data from a remote API.
 *
 * @property tmdbService Service interface for TMDB API communication.
 * @property apiKey The API key used for authenticating requests to the TMDB API.
 */
class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {

    /**
     * Fetch popular artists from the remote TMDB API.
     *
     * @return Response object containing a [ArtistList] if the request is successful.
     */
    override suspend fun getArtists(): Response<ArtistList>
    = tmdbService.getPopularArtists(apiKey)

}
