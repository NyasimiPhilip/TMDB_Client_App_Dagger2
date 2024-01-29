package com.example.tmdb_client_app.data.model.artist
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName= "popular_artists")
data class Artist(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    //@ColumnInfo(name= "artist_name")to set custom column namesggg
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)