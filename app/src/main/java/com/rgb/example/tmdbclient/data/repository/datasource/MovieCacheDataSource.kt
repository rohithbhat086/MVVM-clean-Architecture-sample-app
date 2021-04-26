package com.rgb.example.tmdbclient.data.repository.datasource

import com.rgb.example.tmdbclient.data.model.Movie

interface MovieCacheDataSource {
    fun getAllMovies():List<Movie>

    fun saveMovies(movies : List<Movie>)
}