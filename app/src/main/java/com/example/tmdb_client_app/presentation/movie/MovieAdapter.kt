package com.example.tmdb_client_app.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_client_app.R
import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.databinding.ListItemBinding

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private val movieList = ArrayList<Movie>()
    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
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
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.titleTextView.text = movie.title
            binding.descriptionTextView.text = movie.overview
            val posterURL: String = "https://image.tmdb.org/t/p/original/" + movie.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)

        }
    }
}
