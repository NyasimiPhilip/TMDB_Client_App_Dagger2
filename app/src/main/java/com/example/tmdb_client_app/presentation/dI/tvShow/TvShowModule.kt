package com.example.tmdb_client_app.presentation.dI.tvShow

import com.example.tmdb_client_app.domain.usecase.GetTvShowsUseCase
import com.example.tmdb_client_app.domain.usecase.UpdateTvShowsUseCase
import com.example.tmdb_client_app.presentation.tvShow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    /**
     * Provides an instance of [TvShowViewModelFactory] with the required dependencies.
     *
     * @param getTvShowUseCase The use case for retrieving TV shows.
     * @param updateTvShowUseCase The use case for updating TV shows.
     * @return An instance of [TvShowViewModelFactory] with the provided use cases.
     */
    @Provides
    @TvShowScope
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowsUseCase,
        updateTvShowUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowUseCase,
            updateTvShowUseCase
        )
    }
}
