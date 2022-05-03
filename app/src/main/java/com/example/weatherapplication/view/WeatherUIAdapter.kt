package com.example.weatherapplication.view

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.weatherapplication.R
import com.example.weatherapplication.model.WeatherDataModelItem

class WeatherUIAdapter(private val weather:List<WeatherDataModelItem>):BaseAdapter() {
    override fun getCount(): Int {
        return weather.size

    }

    override fun getItem(position: Int): Any {
        return weather[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = convertView

        if(convertView==null)
        {
            view = View.inflate(parent?.context, R.layout.weather_list_view,parent?.let{null})
        }

        val hum : TextView? = view?.findViewById(R.id.hum)
        val loc : TextView? = view?.findViewById(R.id.loc)
        val prec : TextView? = view?.findViewById(R.id.prec)
        val state : TextView? = view?.findViewById(R.id.state)
        val temp : TextView? = view?.findViewById(R.id.temp)
        val wind : TextView? = view?.findViewById(R.id.wind)
       /* val humidity : TextView? = view?.findViewById(R.id.humidity)
        val precip : TextView? = view?.findViewById(R.id.precip)
        val wind : TextView? = view?.findViewById(R.id.wind)
        val state : TextView? = view?.findViewById(R.id.state)
        val location : TextView? = view?.findViewById(R.id.location)
        val climate : TextView? = view?.findViewById(R.id.climate)
*/
        /*temperature?.text = this.weather[position].temperature
        humidity?.text = this.weather[position].humidity
        precip?.text = this.weather[position].precip
        wind?.text = this.weather[position].wind
        state?.text = this.weather[position].state
        location?.text = this.weather[position].location
        climate?.text = this.weather[position].climate

*/
        hum?.text = this.weather[position].hum.toString()
        loc?.text =this.weather[position].loc
        prec?.text = this.weather[position].prec.toString()
        state?.text =this.weather[position].state.toString()
        temp?.text =this.weather[position].temp.toString()
        wind?.text =this.weather[position].wind.toString()
        return view
    }
}