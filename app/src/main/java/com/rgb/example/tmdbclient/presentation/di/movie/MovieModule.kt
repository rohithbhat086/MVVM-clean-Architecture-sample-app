package com.rgb.example.tmdbclient.presentation.di.movie

import com.rgb.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.rgb.example.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.rgb.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providesMovieVMFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }

}