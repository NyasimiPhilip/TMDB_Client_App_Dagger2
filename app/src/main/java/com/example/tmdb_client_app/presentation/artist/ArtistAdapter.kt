package com.example.tmdb_client_app.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_client_app.R
import com.example.tmdb_client_app.data.model.artist.Artist
import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.databinding.ListItemBinding

class ArtistAdapter() : RecyclerView.Adapter<ArtistAdapter.MyViewHolder>() {

    private val artistList = ArrayList<Artist>()
    fun setList(artists:List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater :LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val artist = artistList[position]
        holder.bind(artist)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Artist) {
            binding.titleTextView.text = artist.popularity.toString()
            binding.descriptionTextView.text = artist.name
            val posterURL: String = "https://image.tmdb.org/t/p/original/" + artist.profilePath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)

        }
    }
}
