package com.luckydu.weatherapp.db

import java.util.*

/**
 *
 * @author dujun
 *
 * @since 2017-08-17 11:27
 */
class CityForecast(val map: MutableMap<String,Any?>,val dailyForecast:List<DayForecast>) {
    var _id : Long by map
    var city : String by map
    var country : String by map

    constructor(id:Long,city:String,country:String,dailyForecast:List<DayForecast>):this(HashMap(),dailyForecast){
        this._id = id
        this.city = city
        this.country = country
    }
}