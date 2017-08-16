package com.luckydu.weatherapp

import android.app.Application
import kotlin.properties.ReadWriteProperty

/**
 *
 * @author dujun
 *
 * @since 2017-08-16 15:49
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

//    val database: SQLiteOpenHelper by lazy(LazyThreadSafetyMode.NONE) {
//        MyDatabaseHelper(applicationContext)
//    }

    override fun onCreate() {
        super.onCreate()
        instance = this
//        val db = database.writableDatabase
    }
}

object DelegatesExt {
    fun <T> notNullSingleValue():ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}
