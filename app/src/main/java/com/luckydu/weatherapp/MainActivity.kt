package com.luckydu.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.luckydu.weatherapp.domain.RequestForecastCommand
import com.luckydu.weatherapp.domain.model.Forecast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            runOnUiThread {
                forecastList.adapter = ForecastListAdapter(result,object :ForecastListAdapter.OnItemClickListener{
                    override fun invoke(forecast: Forecast){
                        toast(forecast.date)
                    }
                })
            }
        }
    }
}