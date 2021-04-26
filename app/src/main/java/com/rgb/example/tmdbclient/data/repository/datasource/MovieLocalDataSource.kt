package com.rgb.example.tmdbclient.data.repository.datasource

import com.rgb.example.tmdbclient.data.model.Movie

interface MovieLocalDataSource {
    suspend fun getAllMovies():List<Movie>

    suspend fun saveMovies(movies : List<Movie>)

    suspend fun deleteAll()
}