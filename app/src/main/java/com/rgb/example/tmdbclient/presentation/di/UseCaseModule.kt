package com.rgb.example.tmdbclient.presentation.di

import com.rgb.example.tmdbclient.domain.repository.MovieRepository
import com.rgb.example.tmdbclient.domain.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

//    @Provides
//    fun providesGetMoviesUseCase(repository: MovieRepository) : GetMoviesUseCase{
//        return GetMoviesUseCase(repository)
//    }
}