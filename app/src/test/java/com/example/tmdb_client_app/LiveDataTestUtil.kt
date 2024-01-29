package com.example.tmdb_client_app

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * A utility function for testing LiveData objects by blocking until a value is received.
 *
 * @param time The maximum time to wait for the LiveData to be set.
 * @param timeUnit The time unit for the maximum waiting time.
 * @return The value set on the LiveData.
 * @throws TimeoutException If the LiveData value is not set within the specified time.
 */
@VisibleForTesting(otherwise = VisibleForTesting.NONE)
fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2, // Default waiting time is 2 seconds
    timeUnit: TimeUnit = TimeUnit.SECONDS // Default time unit is seconds
): T {
    var data: T? = null // Variable to hold the LiveData value
    val latch = CountDownLatch(1) // Countdown latch to wait for the LiveData to be set
    val observer = object : Observer<T> {
        /**
         * Called when the observed LiveData object is changed.
         * @param o The new value of the LiveData.
         */
        override fun onChanged(o: T) {
            data = o // Set the data when LiveData changes
            latch.countDown() // Countdown the latch to signal that data is set
            this@getOrAwaitValue.removeObserver(this) // Remove the observer to avoid memory leaks
        }
    }

    this.observeForever(observer) // Observe the LiveData with the defined observer

    // Don't wait indefinitely if the LiveData is not set.
    if (!latch.await(time, timeUnit)) {
        throw TimeoutException("LiveData value was never set.")
    }

    @Suppress("UNCHECKED_CAST")
    return data as T // Return the value set on the LiveData
}
