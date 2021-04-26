package com.rgb.example.tmdbclient.presentation.di

import com.rgb.example.tmdbclient.data.db.MovieDAO
import com.rgb.example.tmdbclient.data.repository.datasource.MovieLocalDataSource
import com.rgb.example.tmdbclient.data.repository.datasourceImpl.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule() {

    @Singleton
    @Provides
    fun providesMovieLocalDataSource(dao: MovieDAO):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(dao)
    }
}