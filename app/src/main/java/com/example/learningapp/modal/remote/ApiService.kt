package com.example.learningapp.modal.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    fun getWeatherDetails(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appId: String,
    )
}