package com.luckydu.weatherapp

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * @author dujun
 *
 * @since 2017-08-16 17:17
 */
class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>) : T {
        return value ?: throw IllegalStateException( "not initialized")
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>,value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("already initialized")
    }
}