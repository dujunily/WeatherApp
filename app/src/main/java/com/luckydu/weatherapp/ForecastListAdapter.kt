package com.luckydu.weatherapp

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.luckydu.weatherapp.domain.ForecastList

@Suppress("UNREACHABLE_CODE")
/**
 *
 * @author dujun
 *
 * @since 2017-08-15 17:10
 */
class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // 上面的todo不注释的话，会导致显示没有实现这些方法
        return ViewHolder(TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        with(weekForecast.dailyForecast[position]) {
            holder?.textView?.text = "$date - $description - $high/$low"}
    }

    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return weekForecast.dailyForecast.size
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}