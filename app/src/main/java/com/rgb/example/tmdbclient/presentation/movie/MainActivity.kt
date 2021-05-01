package com.rgb.example.tmdbclient.presentation.movie

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rgb.example.tmdbclient.R
import com.rgb.example.tmdbclient.databinding.ActivityMainBinding
import com.rgb.example.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding
    @Inject
    lateinit var mViewModelFactory : MovieViewModelFactory
    private lateinit var mViewModel: MovieViewModel
    private lateinit var adapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as Injector).getMovieSubComponent().injectMovieActivity(this)

        mViewModel = ViewModelProvider(this, mViewModelFactory).get(MovieViewModel::class.java)
        initRecyclerView()

    }

    private fun initRecyclerView(){
        mBinding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        mBinding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        mBinding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = mViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                mBinding.movieProgressBar.visibility = View.GONE
            }else{
                mBinding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateMovies(){
        mBinding.movieProgressBar.visibility = View.VISIBLE
        val response = mViewModel.updateMovies()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                mBinding.movieProgressBar.visibility = View.GONE
            }else{
                mBinding.movieProgressBar.visibility = View.GONE
            }
        })
    }

}