package com.rgb.example.tmdbclient.data.repository.datasourceImpl

import com.rgb.example.tmdbclient.data.api.TMDBService
import com.rgb.example.tmdbclient.data.model.MovieList
import com.rgb.example.tmdbclient.data.repository.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val service: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getPopularMovies(): Response<MovieList> {
        return service.getPopularMovies(apiKey)
    }
}