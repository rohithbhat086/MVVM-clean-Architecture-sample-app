package com.rgb.example.tmdbclient.data.repository.datasourceImpl

import com.rgb.example.tmdbclient.data.model.Movie
import com.rgb.example.tmdbclient.data.repository.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override fun getAllMovies(): List<Movie> {
        return movieList
    }

    override fun saveMovies(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }
}