package com.example.tmdb_client_app.presentation.dI.movie

import com.example.tmdb_client_app.presentation.movie.MovieActivity
import dagger.Subcomponent

/**
 * Dagger Subcomponent for the Movie feature.
 */
@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    /**
     * Injects dependencies into the [MovieActivity].
     *
     * @param movieActivity The instance of [MovieActivity] to inject dependencies into.
     */
    fun inject(movieActivity: MovieActivity)

    /**
     * Factory interface for creating instances of [MovieSubComponent].
     */
    @Subcomponent.Factory
    interface Factory {
        /**
         * Creates a new instance of [MovieSubComponent].
         *
         * @return A new instance of [MovieSubComponent].
         */
        fun create(): MovieSubComponent
    }
}
