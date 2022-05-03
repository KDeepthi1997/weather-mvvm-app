package com.example.weatherapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapplication.R
import com.example.weatherapplication.service.RestAPIService
import com.example.weatherapplication.service.ServiceLocator


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val weatherFragment = WeatherFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,weatherFragment,"weatherFragment").commit()
    }

}