package com.rgb.example.tmdbclient.presentation.di

import android.content.Context
import androidx.room.Room
import com.rgb.example.tmdbclient.data.db.MovieDAO
import com.rgb.example.tmdbclient.data.db.TMDBLocalDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun providesDatabase(context: Context): TMDBLocalDB {
        return Room.databaseBuilder(context, TMDBLocalDB::class.java, "TMDBClient").build()
    }

    @Singleton
    @Provides
    fun providesMovieDao(db: TMDBLocalDB) : MovieDAO{
        return db.getMovieDao()
    }
}