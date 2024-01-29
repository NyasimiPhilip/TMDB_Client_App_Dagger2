package com.example.tmdb_client_app.presentation.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_client_app.data.model.tvShow.TvShow
import com.example.tmdb_client_app.domain.usecase.GetTvShowsUseCase
import com.example.tmdb_client_app.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase

):ViewModel() {
    fun getTvShows(): LiveData<List<TvShow>?> = liveData{
        val tvShowList: List<TvShow>? = getTvShowsUseCase.execute()
        emit(tvShowList)
    }
    fun updateTvShows(): LiveData<List<TvShow>?> = liveData {
        val tvShowList  = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }

}