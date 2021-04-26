package com.rgb.example.tmdbclient.data.repository.datasourceImpl

import com.rgb.example.tmdbclient.data.db.MovieDAO
import com.rgb.example.tmdbclient.data.model.Movie
import com.rgb.example.tmdbclient.data.repository.datasource.MovieLocalDataSource
import kotlinx.coroutines.*

class MovieLocalDataSourceImpl(
    private val dao: MovieDAO
) : MovieLocalDataSource {

    override suspend fun getAllMovies(): List<Movie> {
        var movies : List<Movie>
        coroutineScope {
            withContext(Dispatchers.IO){
                movies = dao.getAllMovies()
            }
        }
        return movies
    }

    override suspend fun saveMovies(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.saveMovies(movies)
        }
    }

    override suspend fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAll()
        }
    }
}