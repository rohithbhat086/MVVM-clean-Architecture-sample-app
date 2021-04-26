package com.rgb.example.tmdbclient.presentation.di

import com.rgb.example.tmdbclient.presentation.di.movie.MovieSubComponent

interface Injector {

    fun getMovieSubComponent():MovieSubComponent
}