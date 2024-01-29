package com.example.tmdb_client_app.data.repository.tvShow.dataSource

import com.example.tmdb_client_app.data.model.tvShow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(artists: List<TvShow>)
    suspend fun clearAll()
}
