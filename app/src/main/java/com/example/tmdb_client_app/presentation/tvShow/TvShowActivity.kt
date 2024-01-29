package com.example.tmdb_client_app.presentation.tvShow

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
import com.example.tmdb_client_app.data.model.tvShow.TvShow
import com.example.tmdb_client_app.databinding.ActivityTvShowBinding
import com.example.tmdb_client_app.presentation.dI.Injector
import javax.inject.Inject

/**
 * TvShowActivity is the main activity responsible for displaying a list of TV shows.
 *
 * This activity uses Data Binding and Dagger Hilt for dependency injection.
 *
 * @property binding Data binding object for the activity layout.
 * @property factory Dagger Hilt injected ViewModelFactory for TvShowViewModel.
 * @property tvShowViewModel ViewModel for managing TV show-related data.
 * @property adapter Adapter for populating the RecyclerView with TV show items.
 */
class TvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvShowBinding
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter

    /**
     * Initializes the activity, sets up data binding, and injects dependencies.
     *
     * @param savedInstanceState Saved state of the activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the binding object using the generated binding class
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowsSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

        initRecyclerView()
    }



    /**
     * Initializes the RecyclerView with the TvShowAdapter.
     */
    private fun initRecyclerView() {
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        displayPopularTvShows()
    }

    /**
     * Displays a list of popular TV shows in the RecyclerView.
     */
    private fun displayPopularTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
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
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Updates the list of TV shows and refreshes the UI.
     */
    private fun updateTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE

        val response: LiveData<List<TvShow>?> = tvShowViewModel.updateTvShows()

        response.observe(this, Observer { updatedTvShows ->
            if (updatedTvShows != null) {
                // Data updated successfully
                handleUpdatedTvShows(updatedTvShows)
            } else {
                // No data to update or an error occurred
                handleNoDataToUpdate()
            }

            // Set progress bar to GONE after the update attempt
            binding.tvShowProgressBar.visibility = View.GONE
        })
    }

    private fun handleUpdatedTvShows(updatedTvShows: List<TvShow>) {
        adapter.setList(updatedTvShows)
        adapter.notifyDataSetChanged()
    }

    private fun handleNoDataToUpdate() {
        // Show a Toast message indicating that there are no updates available
        Toast.makeText(applicationContext, "No updates available", Toast.LENGTH_SHORT).show()
        // You can also log an error or take other appropriate actions based on your app's requirements
    }
}
