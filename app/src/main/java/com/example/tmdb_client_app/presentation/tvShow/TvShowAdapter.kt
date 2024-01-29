package com.example.tmdb_client_app.presentation.tvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_client_app.R
import com.example.tmdb_client_app.data.model.tvShow.TvShow
import com.example.tmdb_client_app.databinding.ListItemBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tvShow = tvShowList[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TvShow) {
            binding.titleTextView.text = tvShow.name
            binding.descriptionTextView.text = tvShow.overview
            val posterURL: String = "https://image.tmdb.org/t/p/original/" + tvShow.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
    }
}
