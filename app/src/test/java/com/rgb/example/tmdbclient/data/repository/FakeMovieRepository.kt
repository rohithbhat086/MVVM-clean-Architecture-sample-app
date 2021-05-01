package com.rgb.example.tmdbclient.data.repository

import com.rgb.example.tmdbclient.data.model.Movie
import com.rgb.example.tmdbclient.domain.repository.MovieRepository

class FakeMovieRepository: MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return mutableListOf(
            Movie(1,"Overview1", "path1", "date1", "title1"),
            Movie(2,"Overview2", "path2", "date2", "title2")
        )
    }

    override suspend fun updateMovies(): List<Movie> {
        return mutableListOf(
            Movie(3,"Overview3", "path3", "date3", "title3"),
            Movie(4,"Overview4", "path4", "date4", "title4")
        )
    }
}