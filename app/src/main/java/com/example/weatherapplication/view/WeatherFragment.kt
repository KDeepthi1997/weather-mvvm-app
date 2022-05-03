package com.example.weatherapplication.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import com.example.weatherapplication.R
import com.example.weatherapplication.viewmodel.WeatherViewModel
import org.json.JSONObject

const val BASE_URL = "http://81.95.11.105:1997/"


class WeatherFragment() : Fragment() {


    private  var viewModel: WeatherViewModel? = null
    lateinit var listView: ListView
/*
    lateinit var temperatureView: TextView
    lateinit var humidityView: TextView
    lateinit var precipView: TextView
    lateinit var windView: TextView
    lateinit var locationView: TextView
    lateinit var stateView: TextView
    lateinit var climateView: TextView*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View? = inflater.inflate(R.layout.weather_fragment, container, false)
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        main()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = view.findViewById(R.id.list_view)

//        temperatureView = view.findViewById(R.id.temperature)
//        humidityView = view.findViewById(R.id.humidity)
//        precipView = view.findViewById(R.id.precip)
//        windView = view.findViewById(R.id.wind)
//        locationView = view.findViewById(R.id.location)
//        stateView = view.findViewById(R.id.state)
//        climateView = view.findViewById(R.id.climate)


        val json = JSONObject()
        json.put("hum",80 )
        json.put("loc", "London")
        json.put("prec",1 )
        json.put("state","England")
        json.put("temp", 12)
        json.put("wind", 20)

        viewModel?.weatherData(json)




    }

    fun main() {
        //Using Companion Object
//       /* println(Weather.temperature)
//        println(Weather.humidity)
//        println(Weather.precip)
//        println(Weather.wind)
//        println(Weather.location)
//        println(Weather.state)
//        println(Weather.climate)*/


        //Using ViewModel


        viewModel?.weatherReportList?.observe(
            viewLifecycleOwner,
            {
                it?.let {
                    /* temperatureView.text = it.temperature
                     humidityView.text = it.humidity
                     precipView.text = it.precip
                     windView.text = it.wind
                     locationView.text = it.location
                     stateView.text = it.state
                     climateView.text = it.climate*/
                    listView.adapter = WeatherUIAdapter(it)
                    Log.d("data", it.toString())




                }
            })

    }
}