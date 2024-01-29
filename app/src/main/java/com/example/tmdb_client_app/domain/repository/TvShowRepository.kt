package com.example.tmdb_client_app.domain.repository

import com.example.tmdb_client_app.data.model.tvShow.TvShow

interface TvShowRepository {

    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?

}