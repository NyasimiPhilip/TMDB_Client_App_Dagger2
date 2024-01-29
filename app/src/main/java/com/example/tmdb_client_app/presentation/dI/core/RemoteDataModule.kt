package com.example.tmdb_client_app.presentation.dI.core

import com.example.tmdb_client_app.data.api.TMDBService
import com.example.tmdb_client_app.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.tmdb_client_app.data.repository.artist.dataSourceimpl.ArtistRemoteDataSourceImpl
import com.example.tmdb_client_app.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdb_client_app.data.repository.movie.dataSourceimpl.MovieRemoteDataSourceImpl
import com.example.tmdb_client_app.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdb_client_app.data.repository.tvShow.dataSourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    /**
     * Provides a singleton instance of [MovieRemoteDataSource] using the [TMDBService].
     *
     * @param tmdbService The [TMDBService] instance used for creating the [MovieRemoteDataSource].
     * @return The created [MovieRemoteDataSource] instance.
     */
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
           return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    /**
     * Provides a singleton instance of [TvShowRemoteDataSource] using the [TMDBService].
     *
     * @param tmdbService The [TMDBService] instance used for creating the [TvShowRemoteDataSource].
     * @return The created [TvShowRemoteDataSource] instance.
     */
    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    /**
     * Provides a singleton instance of [ArtistRemoteDataSource] using the [TMDBService].
     *
     * @param tmdbService The [TMDBService] instance used for creating the [ArtistRemoteDataSource].
     * @return The created [ArtistRemoteDataSource] instance.
     */
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}
