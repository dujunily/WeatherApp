package com.luckydu.weatherapp

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luckydu.weatherapp.domain.ForecastList
import com.luckydu.weatherapp.domain.model.Forecast
import com.luckydu.weatherapp.ui.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

@Suppress("UNREACHABLE_CODE")
/**
 *
 * @author dujun
 *
 * @since 2017-08-15 17:10
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        // 上面的todo不注释的话，会导致显示没有实现这些方法
        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int {
        return weekForecast.size()
    }

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                Log.d("dujun", iconUrl)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener {
                    itemClick(forecast)
                }
            }
        }
    }
}