package com.example.tmdb_client_app.data.repository.tvShow.dataSource

import com.example.tmdb_client_app.data.model.tvShow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShow:List<TvShow>)

}