package com.example.tmdb_client_app.presentation.artist

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
import com.example.tmdb_client_app.data.model.artist.Artist
import com.example.tmdb_client_app.databinding.ActivityArtistBinding
import com.example.tmdb_client_app.presentation.dI.Injector
import com.example.tmdb_client_app.presentation.movie.ArtistAdapter
import javax.inject.Inject

/**
 * ArtistActivity is the main activity responsible for displaying a list of popular artists.
 *
 * This activity uses Data Binding and Dagger Hilt for dependency injection.
 *
 * @property binding Data binding object for the activity layout.
 * @property factory Dagger Hilt injected ViewModelFactory for ArtistViewModel.
 * @property artistViewModel ViewModel for managing artist-related data.
 * @property adapter Adapter for populating the RecyclerView with artist items.
 */
class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)

        artistViewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularArtists()
    }

    /**
     * Displays a list of popular artists in the RecyclerView.
     */
    private fun displayPopularArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
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
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Updates the list of artists and refreshes the UI.
     */
    private fun updateArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE

        val response: LiveData<List<Artist>?> = artistViewModel.updateArtists()

        response.observe(this, Observer { updatedArtists ->
            if (updatedArtists != null) {
                // Data updated successfully
                handleUpdatedArtists(updatedArtists)
            } else {
                // No data to update or an error occurred
                handleNoDataToUpdate()
            }
            // Set progress bar to GONE after the update attempt
            binding.artistProgressBar.visibility = View.GONE
        })
    }

    private fun handleUpdatedArtists(updatedArtists: List<Artist>) {
        adapter.setList(updatedArtists)
        adapter.notifyDataSetChanged()
    }

    private fun handleNoDataToUpdate() {
        // Show a Toast message indicating that there are no updates available
        Toast.makeText(applicationContext, "No updates available", Toast.LENGTH_SHORT).show()
        // You can also log an error or take other appropriate actions based on your app's requirements
    }
}



