package com.example.tmdb_client_app.presentation.dI.core

import com.example.tmdb_client_app.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {

    /**
     * Provides a singleton instance of [Retrofit].
     *
     * @return The created Retrofit instance.
     */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    /**
     * Provides a singleton instance of [TMDBService].
     *
     * @param retrofit The Retrofit instance.
     * @return The created TMDBService instance.
     */
    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }
}
