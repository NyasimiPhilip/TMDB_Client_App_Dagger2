package com.example.tmdb_client_app.presentation.dI.core

import com.example.tmdb_client_app.presentation.dI.artist.ArtistSubComponent
import com.example.tmdb_client_app.presentation.dI.movie.MovieSubComponent
import com.example.tmdb_client_app.presentation.dI.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules= [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    CacheDataModule::class,
    LocalDataModule::class,
    RemoteDataModule::class
])
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}