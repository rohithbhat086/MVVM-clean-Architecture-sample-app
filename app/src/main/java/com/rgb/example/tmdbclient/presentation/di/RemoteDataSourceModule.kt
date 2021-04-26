package com.rgb.example.tmdbclient.presentation.di

import com.rgb.example.tmdbclient.data.api.TMDBService
import com.rgb.example.tmdbclient.data.repository.datasource.MovieRemoteDataSource
import com.rgb.example.tmdbclient.data.repository.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataSourceModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun providesRemoteMovieDataSource(service: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(service, apiKey)
    }
}