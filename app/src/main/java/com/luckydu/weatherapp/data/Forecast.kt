package com.luckydu.weatherapp.data

/**
 *
 * @author dujun
 *
 * @since 2017-08-16 10:06
 */
data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float, val humidity: Int,
                    val weather: List<Weather>, val speed: Float, val deg: Int, val clouds: Int, val rain: Float)