package com.luckydu.weatherapp.domain

/**
 *
 * @author dujun
 *
 * @since 2017-08-16 10:20
 */
public interface Command<T> {
    fun execute():T
}