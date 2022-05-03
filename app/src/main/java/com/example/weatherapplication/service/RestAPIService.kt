package com.example.weatherapplication.service

import com.example.weatherapplication.api.WeatherAPIInterface
import com.example.weatherapplication.model.WeatherDataModelItem
import com.example.weatherapplication.view.BASE_URL
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class RestAPIService {




    fun createRetrofit():WeatherAPIInterface {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(WeatherAPIInterface::class.java)


//    fun ((List<WeatherDataModelItem>?) -> Unit).getWeatherData() {
//
//
//        val retrofitData = retrofitBuilder.getData()
//        retrofitData.enqueue(object : Callback<List<WeatherDataModelItem>?> {
//            override fun onResponse(
//                call: Call<List<WeatherDataModelItem>?>,
//                response: Response<List<WeatherDataModelItem>?>
//            ) {
//            val responseBody = response.body()
//                this@getWeatherData(responseBody)
//            }
//
//            override fun onFailure(call: Call<List<WeatherDataModelItem>?>, t: Throwable) {
//                this@getWeatherData(null)
//            }
//        })
//    }
    }

}