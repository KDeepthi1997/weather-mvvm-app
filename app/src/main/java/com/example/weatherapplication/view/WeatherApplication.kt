package com.example.weatherapplication

import android.app.Application
import com.example.weatherapplication.api.WeatherAPIInterface
import com.example.weatherapplication.service.RestAPIService
import com.example.weatherapplication.service.ServiceLocator

class WeatherApplication: Application() {

    // this will be created only once when the application will start
    override fun onCreate() {
        super.onCreate()
        // this is the entry point of our application snf er should initialize services here
        val retrofit = RestAPIService().createRetrofit()
        ServiceLocator.registerService<WeatherAPIInterface>(retrofit)
    }
}