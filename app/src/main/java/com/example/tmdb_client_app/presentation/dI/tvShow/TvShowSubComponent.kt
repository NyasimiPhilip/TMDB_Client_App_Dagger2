package com.example.tmdb_client_app.presentation.dI.tvShow

import com.example.tmdb_client_app.presentation.artist.ArtistActivity
import com.example.tmdb_client_app.presentation.dI.movie.MovieModule
import com.example.tmdb_client_app.presentation.tvShow.TvShowActivity
import dagger.Subcomponent

/**
 * Dagger Subcomponent for the TV Show feature.
 */
@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    /**
     * Injects dependencies into the [TvShowActivity].
     *
     * @param tvShowActivity The instance of [TvShowActivity] to inject dependencies into.
     */
    fun inject(tvShowActivity: TvShowActivity)

    /**
     * Factory interface for creating instances of [TvShowSubComponent].
     */
    @Subcomponent.Factory
    interface Factory {
        /**
         * Creates a new instance of [TvShowSubComponent].
         *
         * @return A new instance of [TvShowSubComponent].
         */
        fun create(): TvShowSubComponent
    }
}
