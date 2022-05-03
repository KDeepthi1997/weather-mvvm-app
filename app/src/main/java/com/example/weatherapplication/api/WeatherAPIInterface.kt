package com.example.weatherapplication.api

import com.example.weatherapplication.model.WeatherDataModelItem
import com.example.weatherapplication.view.WeatherUI
import retrofit2.Call
import retrofit2.http.GET

interface WeatherAPIInterface {
    @GET("api/weather/all")
    fun getData(): Call<List<WeatherDataModelItem>>
}