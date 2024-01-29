package com.example.tmdb_client_app.presentation.dI.movie

import com.example.tmdb_client_app.domain.usecase.GetMoviesUseCase
import com.example.tmdb_client_app.domain.usecase.UpdateMoviesUseCase
import com.example.tmdb_client_app.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Dagger module for providing dependencies related to the Movie feature.
 */
@Module
class MovieModule {

    /**
     * Provides an instance of [MovieViewModelFactory] with the required dependencies.
     *
     * @param getMoviesUseCase The use case for retrieving movies.
     * @param updateMovieUseCase The use case for updating movies.
     * @return An instance of [MovieViewModelFactory] with the provided use cases.
     */
    @Provides
    @MovieScope
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMovieUseCase
        )
    }
}
