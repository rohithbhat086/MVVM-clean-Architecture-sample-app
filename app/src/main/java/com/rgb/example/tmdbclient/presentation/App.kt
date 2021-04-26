package com.rgb.example.tmdbclient.presentation

import android.app.Application
import com.rgb.example.tmdbclient.BuildConfig
import com.rgb.example.tmdbclient.presentation.di.*
import com.rgb.example.tmdbclient.presentation.di.movie.MovieSubComponent

class App : Application() , Injector{
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .retroModule(RetroModule(BuildConfig.BASE_URL))
            .remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.API_KEY))
            .build()
    }

    override fun getMovieSubComponent(): MovieSubComponent {
        return appComponent.getMovieSubComponentFactory().create()
    }

}