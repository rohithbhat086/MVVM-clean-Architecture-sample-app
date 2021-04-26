package com.rgb.example.tmdbclient.presentation.di

import com.google.gson.GsonBuilder
import com.rgb.example.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetroModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }

        val client = OkHttpClient.Builder().apply{
            addInterceptor(interceptor)
            connectTimeout(10, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
        }.build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun providesTMDBService(retrofit: Retrofit):TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}