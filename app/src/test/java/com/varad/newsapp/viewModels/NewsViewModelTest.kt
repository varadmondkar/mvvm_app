package com.varad.newsapp.viewModels

import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.varad.newsapp.utils.ConverterUtil
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by varad on 2019-08-20
 */
class NewsViewModelTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun init() {
    }

    @Test
    fun getNewsRepository() {
    }

    @Test
    fun testTemperatureConverter() {
        val value = ConverterUtil.convertCelsiusToFahrenheit(1)

        assertEquals("Conversion is right - ", 33, value)
    }
}