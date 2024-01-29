package com.example.tmdb_client_app.data.repository.tvShow.dataSourceimpl

import com.example.tmdb_client_app.data.model.tvShow.TvShow
import com.example.tmdb_client_app.data.repository.tvShow.dataSource.TvShowCacheDataSource

/**
 * Implementation of [TvShowCacheDataSource] responsible for caching TV show data.
 */
class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    // In-memory storage for the list of TV shows
    private var tvShowList = ArrayList<TvShow>()

    /**
     * Retrieve TV shows from the cache.
     *
     * @return List of TV shows if available in the cache, otherwise an empty list.
     */
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    /**
     * Save a list of TV shows to the cache.
     *
     * @param tvShows The list of TV shows to be saved to the cache.
     */
    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        // Clear the existing list and replace it with the new list of TV shows
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}
