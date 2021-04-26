package com.rgb.example.tmdbclient.data.repository.datasource

import com.rgb.example.tmdbclient.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getPopularMovies():Response<MovieList>
}