package com.rgb.example.tmdbclient.presentation.di.movie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rgb.example.tmdbclient.R
import com.rgb.example.tmdbclient.databinding.ActivityMainBinding
import com.rgb.example.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding
    @Inject
    lateinit var mViewModelFactory : MovieViewModelFactory
    private lateinit var mViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as Injector).getMovieSubComponent().injectMovieActivity(this)

        mViewModel = ViewModelProvider(this, mViewModelFactory).get(MovieViewModel::class.java)
        showPopularMovies()

    }

    private fun showPopularMovies(){
        val moviesLiveData = mViewModel.getMovies()
        moviesLiveData.observe(this, Observer {
            Log.i("TMDB", "$it")
        })
    }
}