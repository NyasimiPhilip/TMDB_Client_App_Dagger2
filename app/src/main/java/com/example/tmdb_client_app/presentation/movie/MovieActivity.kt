package com.example.tmdb_client_app.presentation.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb_client_app.R
import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.databinding.ActivityMovieBinding
import com.example.tmdb_client_app.presentation.dI.Injector
import javax.inject.Inject

/**
 * MovieActivity is the main activity responsible for displaying a list of movies.
 *
 * This activity uses Data Binding and Dagger Hilt for dependency injection.
 *
 * @property binding Data binding object for the activity layout.
 * @property factory Dagger Hilt injected ViewModelFactory for MovieViewModel.
 * @property movieViewModel ViewModel for managing movie-related data.
 * @property adapter Adapter for populating the RecyclerView with movie items.
 */

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter


    /**
     * Initializes the activity, sets up data binding, and injects dependencies.
     *
     * @param savedInstanceState Saved state of the activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the binding object using the generated binding class
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMoviesSubComponent()
            .inject(this)


        movieViewModel = ViewModelProvider(this, factory )[MovieViewModel::class.java]

        initRecyclerView()
        /**
         * val responseLiveData: LiveData<List<Movie>?> = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.i("MYTAG", it.toString())
        })
         */
    }
    /**
     * Initializes the RecyclerView with the MovieAdapter.
     */
    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    /**
     * Displays a list of popular movies in the RecyclerView.
     */
    private fun displayPopularMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
    /**
     * Inflates the options menu for the activity.
     *
     * @param menu The options menu to be inflated.
     * @return True if the menu is successfully inflated, false otherwise.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    /**
     * Handles options menu item selection.
     *
     * @param item The selected menu item.
     * @return True if the menu item is handled, false otherwise.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Updates the list of movies and refreshes the UI.
     */
    private fun updateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE

        val response: LiveData<List<Movie>?> = movieViewModel.updateMovies()

        response.observe(this, Observer { updatedMovies ->
            if (updatedMovies != null) {
                // Data updated successfully
                handleUpdatedMovies(updatedMovies)
            } else {
                // No data to update or an error occurred
                handleNoDataToUpdate()
            }

            // Set progress bar to GONE after the update attempt
            binding.movieProgressBar.visibility = View.GONE
        })
    }

    private fun handleUpdatedMovies(updatedMovies: List<Movie>) {
        adapter.setList(updatedMovies)
        adapter.notifyDataSetChanged()
    }
    private fun handleNoDataToUpdate() {
        // Show a Toast message indicating that there are no updates available
        Toast.makeText(applicationContext, "No updates available", Toast.LENGTH_SHORT).show()
        // You can also log an error or take other appropriate actions based on your app's requirements
    }
}
