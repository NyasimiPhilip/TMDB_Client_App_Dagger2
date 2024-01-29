package com.example.tmdb_client_app.presentation.dI.core

import com.example.tmdb_client_app.data.repository.artist.ArtistRepositoryImpl
import com.example.tmdb_client_app.data.repository.artist.dataSource.ArtistCacheDataSource
import com.example.tmdb_client_app.data.repository.artist.dataSource.ArtistLocalDataSource
import com.example.tmdb_client_app.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.tmdb_client_app.data.repository.movie.MovieRepositoryImpl
import com.example.tmdb_client_app.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.tmdb_client_app.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.tmdb_client_app.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdb_client_app.data.repository.tvShow.TvShowRepositoryImpl
import com.example.tmdb_client_app.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.tmdb_client_app.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.tmdb_client_app.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdb_client_app.domain.repository.ArtistRepository
import com.example.tmdb_client_app.domain.repository.MovieRepository
import com.example.tmdb_client_app.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    /**
     * Provides a singleton instance of [MovieRepository].
     *
     * @param movieCacheDataSource The cache data source for movies.
     * @param movieLocalDataSource The local data source for movies.
     * @param movieRemoteDataSource The remote data source for movies.
     * @return The created [MovieRepository] instance.
     */
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDataSource: MovieRemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    /**
     * Provides a singleton instance of [TvShowRepository].
     *
     * @param tvShowCacheDataSource The cache data source for TV shows.
     * @param tvShowLocalDataSource The local data source for TV shows.
     * @param tvShowRemoteDataSource The remote data source for TV shows.
     * @return The created [TvShowRepository] instance.
     */
    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowRemoteDataSource: TvShowRemoteDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    /**
     * Provides a singleton instance of [ArtistRepository].
     *
     * @param artistCacheDataSource The cache data source for artists.
     * @param artistLocalDataSource The local data source for artists.
     * @param artistRemoteDataSource The remote data source for artists.
     * @return The created [ArtistRepository] instance.
     */
    @Singleton
    @Provides
    fun provideArtistRepository(
        artistCacheDataSource: ArtistCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistRemoteDataSource: ArtistRemoteDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}
