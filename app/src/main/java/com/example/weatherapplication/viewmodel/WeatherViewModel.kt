package com.example.weatherapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.api.WeatherAPIInterface
import com.example.weatherapplication.model.WeatherDataModel
import com.example.weatherapplication.service.RestAPIService
import com.example.weatherapplication.model.WeatherDataModelItem
import com.example.weatherapplication.service.ServiceLocator
import com.example.weatherapplication.view.WeatherUI
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel : ViewModel() {

    //val weatherReportList = MutableLiveData<WeatherUI?>()
    //var weatherReportList = MutableLiveData<List<WeatherUI>?>()
    val weatherReportList = MutableLiveData<List<WeatherUI>?>()
    //val weatherReportUIList = MutableLiveData<List<WeatherUI>?>()



    val weatherData = WeatherDataModel()

    //var APP_CONTENT_TYPE:String = "text/plain"

    //val weatherData = WeatherAPI()

    fun transformWeatherData(weatherData: WeatherDataModelItem) : WeatherUI {

        val hum =  weatherData.hum
        val loc = weatherData.loc
        val prec = weatherData.prec
        val state = weatherData.state
        val temp = convertTemp(weatherData.temp.toFloat(),false)
        val wind = weatherData.wind


        return WeatherUI("${hum} %",loc,"${prec}%",
        "${state}","${temp} F","${wind}Km/hr")
    }


    fun convertTemp(temp: Float, isFahrenheit:Boolean):Float =
        if(isFahrenheit) ((temp - 32) * 0.5556).toFloat() else  ((temp * 1.8) + 32).toFloat()

    fun getWeatherData(onResult: (List<WeatherUI>?) -> Unit)  {
       val retrofit = ServiceLocator.getService<WeatherAPIInterface>()
       retrofit.getData().enqueue(object : Callback<List<WeatherUI>> {
           override fun onResponse(
               call: Call<List<WeatherUI>>,
               response: Response<List<WeatherUI>>
           ) {

               val weatherItems = response.body()
               onResult(weatherItems)


           }

           override fun onFailure(call: Call<List<WeatherUI>>, t: Throwable) {
               onResult(null)
           }

       })
   }


       fun weatherData(){
            getWeatherData(){
                if(it!= null) {
                    weatherReportList.postValue(it)

                     val responseData = weatherData

                    val weatherUI:List<WeatherUI> = responseData.map { weather: WeatherDataModelItem ->
                        transformWeatherData(weather)

                        //here you can transform your data to MoviesUI once returned here it will create List of MoviesUI
                    }
                }
            }

                } /*else {
               weatherReportList.postValue(null)
                }*/


        /*val responseData = weatherData.getWeatherData()

        val weatherUI:List<WeatherUI> = responseData.map { weather: Weather ->
            transformWeatherData(weather)
            //here you can transform your data to MoviesUI once returned here it will create List of MoviesUI

        }*/
        // here  you created a new api service and this is not noecessary or even good
        // so what you would need to here is to access the apiservice instance that has been created only once and then use the getData function that you created
        // to get the weather date
        //val mediaType = APP_CONTENT_TYPE.toMediaTypeOrNull()


        //val body =
            ///json.toString().toRequestBody(mediaType)
//        apiService.getWeatherData() {
//            if (it != null) {
//                weatherReportList.postValue(it)
//            } else {
//                weatherReportList.postValue(null)
//            }
//        }
        //weatherReportList.postValue(weatherUI)
    }





