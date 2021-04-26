package com.rgb.example.tmdbclient.presentation.di

import com.rgb.example.tmdbclient.data.repository.MovieRepositoryImpl
import com.rgb.example.tmdbclient.data.repository.datasource.MovieCacheDataSource
import com.rgb.example.tmdbclient.data.repository.datasource.MovieLocalDataSource
import com.rgb.example.tmdbclient.data.repository.datasource.MovieRemoteDataSource
import com.rgb.example.tmdbclient.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
        remoteDataSource: MovieRemoteDataSource,
        localDataSource: MovieLocalDataSource,
        cacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(remoteDataSource, localDataSource, cacheDataSource)
    }
}