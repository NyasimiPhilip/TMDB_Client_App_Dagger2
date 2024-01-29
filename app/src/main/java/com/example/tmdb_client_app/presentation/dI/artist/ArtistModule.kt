package com.example.tmdb_client_app.presentation.dI.artist

import com.example.tmdb_client_app.domain.usecase.GetArtistsUseCase
import com.example.tmdb_client_app.domain.usecase.UpdateArtistsUseCase
import com.example.tmdb_client_app.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Dagger module for providing dependencies related to the Artist feature.
 */
@Module
class ArtistModule {

    /**
     * Provides an instance of [ArtistViewModelFactory] with the required dependencies.
     *
     * @param getArtistsUseCase The use case for retrieving artists.
     * @param updateArtistUseCase The use case for updating artists.
     * @return An instance of [ArtistViewModelFactory] with the provided use cases.
     */
    @Provides
    @ArtistScope
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistUseCase
        )
    }
}
