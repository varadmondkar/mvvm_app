package com.varad.newsapp.utils

/**
 * Created by varad on 2019-08-20
 */
object ConverterUtil {

    fun convertCelsiusToFahrenheit(temp: Int): Any {
        return (temp * 9 / 5) + 32
    }
}