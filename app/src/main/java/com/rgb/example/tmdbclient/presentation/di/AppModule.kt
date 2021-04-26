package com.rgb.example.tmdbclient.presentation.di

import android.content.Context
import com.rgb.example.tmdbclient.presentation.di.movie.MovieSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun providesAppContext():Context{
        return context.applicationContext
    }
}