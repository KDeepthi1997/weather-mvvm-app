package com.example.weatherapplication.model

data class Weather(
    var temperature: Int,
    var humidity: Int,
    var precip: String,
    var wind: String,
    var location : String,
    var state : String,
    var climate : String
)

/*{
    companion object
    {
        var temperature =35
        var humidity = 83
        var precip = 10
        var wind = "5km/hr"
        var location = "Ongole"
        var state  = "Andhra Pradesh"
        var climate = "Sunny"
    }*/

