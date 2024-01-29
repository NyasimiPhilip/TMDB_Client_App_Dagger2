package com.example.tmdb_client_app.data.model.movie


import com.example.tmdb_client_app.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    val movies: List<Movie>,

    )