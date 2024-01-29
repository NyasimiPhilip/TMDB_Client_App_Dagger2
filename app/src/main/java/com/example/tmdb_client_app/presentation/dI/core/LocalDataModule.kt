package com.example.tmdb_client_app.presentation.dI.core

import com.example.tmdb_client_app.data.db.ArtistDao
import com.example.tmdb_client_app.data.db.MovieDao
import com.example.tmdb_client_app.data.db.TvShowDao
import com.example.tmdb_client_app.data.repository.artist.dataSource.ArtistLocalDataSource
import com.example.tmdb_client_app.data.repository.artist.dataSourceimpl.ArtistLocalDataSourceImpl
import com.example.tmdb_client_app.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.tmdb_client_app.data.repository.movie.dataSourceimpl.MovieLocalDataSourceImpl
import com.example.tmdb_client_app.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.tmdb_client_app.data.repository.tvShow.dataSourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    /**
     * Provides a singleton instance of [MovieLocalDataSource] using [MovieDao].
     *
     * @param movieDao The [MovieDao] instance used for creating [MovieLocalDataSource].
     * @return The created [MovieLocalDataSource] instance.
     */
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    /**
     * Provides a singleton instance of [TvShowLocalDataSource] using [TvShowDao].
     *
     * @param tvShowDao The [TvShowDao] instance used for creating [TvShowLocalDataSource].
     * @return The created [TvShowLocalDataSource] instance.
     */
    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    /**
     * Provides a singleton instance of [ArtistLocalDataSource] using [ArtistDao].
     *
     * @param artistDao The [ArtistDao] instance used for creating [ArtistLocalDataSource].
     * @return The created [ArtistLocalDataSource] instance.
     */
    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}
