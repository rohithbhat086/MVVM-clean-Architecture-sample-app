package com.rgb.example.tmdbclient.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anushka.tmdbclient.getOrAwaitValue
import com.rgb.example.tmdbclient.data.model.Movie
import com.rgb.example.tmdbclient.data.repository.FakeMovieRepository
import com.rgb.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.rgb.example.tmdbclient.domain.usecase.UpdateMoviesUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.google.common.truth.Truth.assertThat
import com.rgb.example.tmdbclient.presentation.movie.MovieViewModel

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeRepository)
        movieViewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_test(){
        var movies = mutableListOf(
            Movie(1,"Overview1", "path1", "date1", "title1"),
            Movie(2,"Overview2", "path2", "date2", "title2")
        )
        var movieList = movieViewModel.getMovies().getOrAwaitValue()
        assertThat(movieList).isEqualTo(movies)


    }

    @Test
    fun updateMovies_test(){
        var movies =  mutableListOf(
            Movie(3,"Overview3", "path3", "date3", "title3"),
            Movie(4,"Overview4", "path4", "date4", "title4")
        )
        var movieList = movieViewModel.updateMovies().getOrAwaitValue()
        assertThat(movieList).isEqualTo(movies)


    }
}