package com.example.tmdb_client_app.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdb_client_app.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// Annotations and imports
@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    // JUnit rule to execute tasks instantly for LiveData testing
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    // Variables for DAO and in-memory Room database
    private lateinit var dao: MovieDao
    private lateinit var database: TMDBDatabase

    // Setup method to run before each test
    @Before
    fun setUp() {
        // Initialize an in-memory Room database for testing
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        // Assign the MovieDao instance from the database to the 'dao' variable
        dao = database.movieDao()
    }

    // Tear down method to run after each test
    @After
    fun tearDown() {
        // Close the in-memory Room database after tests
        database.close()
    }

    @Test
    fun saveMoviesTest(): Unit = runBlocking {
        // Create a list of Movie objects for testing
        val movies = listOf(
            Movie(1, "overview1", "posterPath1", "date1", "title1"),
            Movie(2, "overview2", "posterPath2", "date2", "title2"),
            Movie(3, "overview3", "posterPath3", "date3", "title3")
        )
        // Save the list of movies to the database using the MovieDao
        dao.saveMovies(movies)
        // Retrieve all movies from the database
        val allMovies = dao.getMovies()
        // Assert that the retrieved movies match the saved movies
        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMoviesTest(): Unit = runBlocking {
        // Create a list of Movie objects for testing
        val movies = listOf(
            Movie(1, "overview1", "posterPath1", "date1", "title1"),
            Movie(2, "overview2", "posterPath2", "date2", "title2"),
            Movie(3, "overview3", "posterPath3", "date3", "title3")
        )
        // Save the list of movies to the database using the MovieDao
        dao.saveMovies(movies)
        // Delete all movies from the database
        dao.deleteAllMovies()
        // Retrieve movies after deletion
        val moviesResult = dao.getMovies()
        // Assert that no movies are present after deletion
        Truth.assertThat(moviesResult).isEmpty()
    }
}
