package com.rgb.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rgb.example.tmdbclient.data.model.Movie

@Dao
interface MovieDAO {

    @Query("Select * from movie_detail")
    suspend fun getAllMovies():List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Movie>)

    @Query("Delete from movie_detail")
    suspend fun deleteAll()
}