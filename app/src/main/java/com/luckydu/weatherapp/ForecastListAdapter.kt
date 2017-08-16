package com.luckydu.weatherapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.luckydu.weatherapp.domain.ForecastList
import com.luckydu.weatherapp.domain.model.Forecast
import com.luckydu.weatherapp.ui.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

@Suppress("UNREACHABLE_CODE")
/**
 *
 * @author dujun
 *
 * @since 2017-08-15 17:10
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: ForecastListAdapter.OnItemClickListener) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

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

    class ViewHolder(view: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        private val iconView: ImageView = view.find(R.id.icon)
        private val dateView: TextView = view.find(R.id.date)
        private val descriptionView: TextView = view.find(R.id.description)
        private val maxTemperatureView: TextView = view.find(R.id.maxTemperature)
        private val minTemperatureView: TextView = view.find(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.setOnClickListener{
                    itemClick(forecast)
                }
            }
        }
    }

    public interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}