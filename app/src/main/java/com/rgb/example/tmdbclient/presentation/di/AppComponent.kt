package com.rgb.example.tmdbclient.presentation.di

import com.rgb.example.tmdbclient.presentation.di.movie.MovieSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheDataModule::class,
        DataBaseModule::class,
        LocalDataSourceModule::class,
        RemoteDataSourceModule::class,
        RepositoryModule::class,
        RetroModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun getMovieSubComponentFactory():MovieSubComponent.Factory
}