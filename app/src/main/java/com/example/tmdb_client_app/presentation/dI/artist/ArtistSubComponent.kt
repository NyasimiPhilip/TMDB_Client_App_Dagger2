package com.example.tmdb_client_app.presentation.dI.artist

import com.example.tmdb_client_app.presentation.artist.ArtistActivity
import com.example.tmdb_client_app.presentation.dI.movie.MovieModule
import dagger.Subcomponent

/**
 * Dagger Subcomponent for the Artist feature.
 */
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    /**
     * Injects dependencies into the [ArtistActivity].
     *
     * @param artistActivity The instance of [ArtistActivity] to inject dependencies into.
     */
    fun inject(artistActivity: ArtistActivity)

    /**
     * Factory interface for creating instances of [ArtistSubComponent].
     */
    @Subcomponent.Factory
    interface Factory {
        /**
         * Creates a new instance of [ArtistSubComponent].
         *
         * @return A new instance of [ArtistSubComponent].
         */
        fun create(): ArtistSubComponent
    }
}
