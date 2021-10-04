package com.lemon.team.superhero.model.network

import com.lemon.team.superhero.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    private val clientForInterceptor = OkHttpClient.Builder().addInterceptor( HttpLoggingInterceptor()).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(clientForInterceptor)
        .build()

    val apiService = retrofit.create(SuperHeroService::class.java)

}