package com.example.tmdb_client_app.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.tmdb_client_app.R
import com.example.tmdb_client_app.databinding.ActivityHomeBinding
import com.example.tmdb_client_app.presentation.artist.ArtistActivity
import com.example.tmdb_client_app.presentation.movie.MovieActivity
import com.example.tmdb_client_app.presentation.tvShow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.movieButton.setOnClickListener{

            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)

        }
        binding.tvButton.setOnClickListener{

            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }
        binding.artistsButton.setOnClickListener{

            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}