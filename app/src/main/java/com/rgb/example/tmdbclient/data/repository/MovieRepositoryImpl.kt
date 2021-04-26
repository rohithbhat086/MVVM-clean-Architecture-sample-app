package com.rgb.example.tmdbclient.data.repository

import android.util.Log
import com.rgb.example.tmdbclient.data.model.Movie
import com.rgb.example.tmdbclient.data.repository.datasource.MovieCacheDataSource
import com.rgb.example.tmdbclient.data.repository.datasource.MovieLocalDataSource
import com.rgb.example.tmdbclient.data.repository.datasource.MovieRemoteDataSource
import com.rgb.example.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieLocalDataSource,
    private val cacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newData = getMoviesFromRemoteServer()
        localDataSource.deleteAll()
        localDataSource.saveMovies(newData)
        cacheDataSource.saveMovies(newData)
        return newData
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movies : List<Movie>
        try {
            movies = cacheDataSource.getAllMovies()
        } catch (ex : Exception){
            Log.i("TMDB", "error while getting data from cache")
        }

        if (movies.isEmpty()){
            movies = getMoviesFromDB()
            cacheDataSource.saveMovies(movies)
        }
        return movies
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movies : List<Movie>
        try {
            movies = localDataSource.getAllMovies()
        } catch (ex : Exception){
            Log.i("TMDB", "error while getting data from db")
        }

        if (movies.isEmpty()){
            movies = getMoviesFromRemoteServer()
            localDataSource.saveMovies(movies)
        }
        return movies
    }

    private suspend fun getMoviesFromRemoteServer(): List<Movie> {
        lateinit var moviesList : List<Movie>
        try {
            val response = remoteDataSource.getPopularMovies()
            if (response.isSuccessful && response.body() != null){
                moviesList = response.body()!!.movies
            } else{
                Log.i("TMDB", "No data from remote")
            }
        } catch (ex : Exception){
            Log.i("TMDB", "error while getting data from Remote")
        }

        return moviesList
    }
}