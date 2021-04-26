package com.rgb.example.tmdbclient.domain.usecase

import com.rgb.example.tmdbclient.data.model.Movie
import com.rgb.example.tmdbclient.domain.repository.MovieRepository
import javax.inject.Inject

class UpdateMoviesUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend fun execute(): List<Movie> {
        return repository.updateMovies()
    }
}