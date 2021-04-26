package com.rgb.example.tmdbclient.domain.repository

import com.rgb.example.tmdbclient.data.model.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>
    suspend fun updateMovies():List<Movie>
}