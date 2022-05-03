package com.example.weatherapplication.model

data class WeatherDataModelItem(
    val hum: Int,
    val loc: String,
    val prec: Double,
    val state: State,
    val temp: Int,
    val wind: Int
)