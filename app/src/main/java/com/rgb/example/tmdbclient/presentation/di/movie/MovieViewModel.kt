package com.rgb.example.tmdbclient.presentation.di.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rgb.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.rgb.example.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}