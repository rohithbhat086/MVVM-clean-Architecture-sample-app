package com.rgb.example.tmdbclient.presentation.di

import com.rgb.example.tmdbclient.data.repository.datasource.MovieCacheDataSource
import com.rgb.example.tmdbclient.data.repository.datasourceImpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

}