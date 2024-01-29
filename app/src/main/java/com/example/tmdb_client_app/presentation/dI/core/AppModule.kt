package com.example.tmdb_client_app.presentation.dI.core

import android.content.Context
import com.example.tmdb_client_app.presentation.dI.artist.ArtistSubComponent
import com.example.tmdb_client_app.presentation.dI.movie.MovieSubComponent
import com.example.tmdb_client_app.presentation.dI.tvShow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents =  [
    MovieSubComponent::class,
    TvShowSubComponent::class,
    ArtistSubComponent::class])
class AppModule(private val context: Context) {

    /**
     * Provides the application context.
     *
     * @return The application context provided as a singleton.
     */
    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}
