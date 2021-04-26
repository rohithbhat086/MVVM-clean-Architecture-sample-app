package com.rgb.example.tmdbclient.presentation.di.movie

import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun injectMovieActivity(movieActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():MovieSubComponent
    }
}