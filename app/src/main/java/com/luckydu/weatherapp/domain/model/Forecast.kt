package com.luckydu.weatherapp.domain.model

/**
 *
 * @author dujun
 *
 * @since 2017-08-16 10:23
 */
data class Forecast(val date: String, val description: String, val high: Int, val low: Int,val iconUrl: String)