package com.luckydu.weatherapp.data

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 *
 * @author dujun
 *
 * @since 2017-08-16 09:37
 */
class ForecastRequest(val zipCode:String) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val API_URL = "http://api.openweathermap.org/data/2.5/" + "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$API_URL&APPID=$APP_ID&q="
    }

    fun execute():ForecastResult{
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        Log.d("dujun",forecastJsonStr)
        return Gson().fromJson(forecastJsonStr,ForecastResult::class.java)
    }
}