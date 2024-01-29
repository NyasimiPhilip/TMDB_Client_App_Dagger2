package com.example.tmdb_client_app.presentation.dI.core

import com.example.tmdb_client_app.data.repository.artist.dataSource.ArtistCacheDataSource
import com.example.tmdb_client_app.data.repository.artist.dataSourceimpl.ArtistCacheDataSourceImpl
import com.example.tmdb_client_app.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.tmdb_client_app.data.repository.movie.dataSourceimpl.MovieCacheDataSourceImpl
import com.example.tmdb_client_app.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.tmdb_client_app.data.repository.tvShow.dataSourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    /**
     * Provides a singleton instance of [MovieCacheDataSource].
     *
     * @return The created [MovieCacheDataSource] instance.
     */
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    /**
     * Provides a singleton instance of [TvShowCacheDataSource].
     *
     * @return The created [TvShowCacheDataSource] instance.
     */
    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    /**
     * Provides a singleton instance of [ArtistCacheDataSource].
     *
     * @return The created [ArtistCacheDataSource] instance.
     */
    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}
