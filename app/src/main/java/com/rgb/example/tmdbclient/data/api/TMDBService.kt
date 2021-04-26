package com.rgb.example.tmdbclient.data.api

import com.rgb.example.tmdbclient.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey: String):Response<MovieList>
}