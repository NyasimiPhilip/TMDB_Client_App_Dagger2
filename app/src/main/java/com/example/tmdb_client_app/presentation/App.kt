package com.example.tmdb_client_app.presentation

import android.app.Application
import com.example.tmdb_client_app.BuildConfig
import com.example.tmdb_client_app.presentation.dI.Injector
import com.example.tmdb_client_app.presentation.dI.artist.ArtistSubComponent
import com.example.tmdb_client_app.presentation.dI.core.AppComponent
import com.example.tmdb_client_app.presentation.dI.core.AppModule
import com.example.tmdb_client_app.presentation.dI.core.DaggerAppComponent
import com.example.tmdb_client_app.presentation.dI.core.NetModule
import com.example.tmdb_client_app.presentation.dI.core.RemoteDataModule
import com.example.tmdb_client_app.presentation.dI.movie.MovieSubComponent
import com.example.tmdb_client_app.presentation.dI.tvShow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMoviesSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowsSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}
