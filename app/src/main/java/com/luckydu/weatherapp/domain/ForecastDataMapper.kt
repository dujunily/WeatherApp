package com.luckydu.weatherapp.domain

import com.luckydu.weatherapp.data.Forecast
import com.luckydu.weatherapp.data.ForecastResult
import java.text.DateFormat
import java.util.*

import com.luckydu.weatherapp.domain.model.Forecast as ModelForecast

/**
 *
 * @author dujun
 *
 * @since 2017-08-16 10:25
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult):ForecastList{
        return ForecastList(forecast.city.name,forecast.city.country,convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<com.luckydu.weatherapp.data.Forecast>): List<ModelForecast> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt(),generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return "http://openweathermap.org/img/w/$iconCode.png"
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}