package com.example.weatherapplication.model

import com.example.weatherapplication.model.Weather

class WeatherAPI {

    /*fun getWeatherData():Weather{
        return Weather(12,12,"pre","5","ongole","Ap","Sunny")
    }*/
    fun getWeatherData() : List<Weather>{
        return mutableListOf(createWeatherReport(12,12,"pre","5","ongole","Ap","Sunny"),
            createWeatherReport(12,12,"pre","5","ongole","Ap","Sunny"))
    }


    //this is just to create hardcoded movie, we could pass more values there
    fun createWeatherReport(temperature: Int, humidity: Int, precip: String, wind: String, location : String, state : String, climate : String): Weather {
        return Weather(12,12,precip,wind,location,state,climate)
    }

}