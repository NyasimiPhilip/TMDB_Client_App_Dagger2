package com.example.tmdb_client_app.presentation.dI.core

import com.example.tmdb_client_app.domain.repository.ArtistRepository
import com.example.tmdb_client_app.domain.repository.MovieRepository
import com.example.tmdb_client_app.domain.repository.TvShowRepository
import com.example.tmdb_client_app.domain.usecase.GetArtistsUseCase
import com.example.tmdb_client_app.domain.usecase.GetMoviesUseCase
import com.example.tmdb_client_app.domain.usecase.GetTvShowsUseCase
import com.example.tmdb_client_app.domain.usecase.UpdateArtistsUseCase
import com.example.tmdb_client_app.domain.usecase.UpdateMoviesUseCase
import com.example.tmdb_client_app.domain.usecase.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    /**
     * Provides a GetMoviesUseCase instance.
     *
     * @param movieRepository The MovieRepository instance used by the use case.
     * @return The created GetMoviesUseCase instance.
     */
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    /**
     * Provides an UpdateMoviesUseCase instance.
     *
     * @param movieRepository The MovieRepository instance used by the use case.
     * @return The created UpdateMoviesUseCase instance.
     */
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    /**
     * Provides a GetArtistsUseCase instance.
     *
     * @param artistRepository The ArtistRepository instance used by the use case.
     * @return The created GetArtistsUseCase instance.
     */
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    /**
     * Provides an UpdateArtistsUseCase instance.
     *
     * @param artistRepository The ArtistRepository instance used by the use case.
     * @return The created UpdateArtistsUseCase instance.
     */
    @Provides
    fun provideUpdateAristUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

    /**
     * Provides a GetTvShowsUseCase instance.
     *
     * @param tvShowRepository The TvShowRepository instance used by the use case.
     * @return The created GetTvShowsUseCase instance.
     */
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    /**
     * Provides an UpdateTvShowsUseCase instance.
     *
     * @param tvShowRepository The TvShowRepository instance used by the use case.
     * @return The created UpdateTvShowsUseCase instance.
     */
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }
}
