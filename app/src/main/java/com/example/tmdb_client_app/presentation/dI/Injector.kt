package com.example.tmdb_client_app.presentation.dI

import com.example.tmdb_client_app.presentation.dI.artist.ArtistSubComponent
import com.example.tmdb_client_app.presentation.dI.movie.MovieSubComponent
import com.example.tmdb_client_app.presentation.dI.tvShow.TvShowSubComponent

interface Injector {
    fun createMoviesSubComponent():MovieSubComponent
    fun createTvShowsSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent

}