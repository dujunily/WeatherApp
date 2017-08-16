package com.luckydu.weatherapp.domain

import com.luckydu.weatherapp.data.ForecastRequest

/**
 *
 * @author dujun
 *
 * @since 2017-08-16 10:31
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}