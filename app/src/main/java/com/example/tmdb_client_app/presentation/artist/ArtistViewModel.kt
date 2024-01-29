package com.example.tmdb_client_app.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_client_app.data.model.artist.Artist
import com.example.tmdb_client_app.domain.usecase.GetArtistsUseCase
import com.example.tmdb_client_app.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {

    fun getArtists(): LiveData<List<Artist>?> = liveData{
        val artistList: List<Artist>? = getArtistsUseCase.execute()
        emit(artistList)
    }
    fun updateArtists(): LiveData<List<Artist>?> = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }

}