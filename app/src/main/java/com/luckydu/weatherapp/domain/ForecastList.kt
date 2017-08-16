package com.luckydu.weatherapp.domain

import com.luckydu.weatherapp.domain.model.Forecast

/**
 *
 * @author dujun
 *
 * @since 2017-08-16 10:22
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast:List<Forecast>){
    operator fun get(position: Int): Forecast = dailyForecast[position]
    fun size(): Int = dailyForecast.size
}