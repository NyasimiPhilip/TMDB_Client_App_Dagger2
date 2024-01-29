package com.example.tmdb_client_app.presentation.dI.core

import android.content.Context
import androidx.room.Room
import com.example.tmdb_client_app.data.db.ArtistDao
import com.example.tmdb_client_app.data.db.MovieDao
import com.example.tmdb_client_app.data.db.TMDBDatabase
import com.example.tmdb_client_app.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    /**
     * Provides a singleton instance of [TMDBDatabase].
     *
     * @param context The application context.
     * @return The created database instance.
     */
    @Provides
    @Singleton
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbClient")
            //.fallbackToDestructiveMigration() // Handle migrations if needed, or use fallbackToDestructiveMigration() for simplicity
            .build()
    }

    /**
     * Provides a singleton instance of [MovieDao].
     *
     * @param tmdbDatabase The database instance.
     * @return The created MovieDao instance.
     */
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    /**
     * Provides a singleton instance of [TvShowDao].
     *
     * @param tmdbDatabase The database instance.
     * @return The created TvShowDao instance.
     */
    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvDao()
    }

    /**
     * Provides a singleton instance of [ArtistDao].
     *
     * @param tmdbDatabase The database instance.
     * @return The created ArtistDao instance.
     */
    @Singleton
    @Provides
    fun provideArtistsDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }
}
