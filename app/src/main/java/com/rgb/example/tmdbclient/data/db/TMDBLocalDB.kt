package com.rgb.example.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rgb.example.tmdbclient.data.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class TMDBLocalDB : RoomDatabase(){

    abstract fun getMovieDao():MovieDAO
}