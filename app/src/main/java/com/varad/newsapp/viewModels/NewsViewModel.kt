package com.varad.newsapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.varad.newsapp.config.Constants
import com.varad.newsapp.models.NewsResponse
import com.varad.newsapp.networking.NewsRepository
import com.varad.newsapp.utils.ConverterUtil


/**
 * Created by varad on 2019-08-19
 */
class NewsViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<NewsResponse>? = null
    private var newsRepository: NewsRepository? = null

    fun init() {
        if (mutableLiveData != null) {
            return
        }
        newsRepository = NewsRepository.instance
//        mutableLiveData = newsRepository?.getNews("google-news")
        mutableLiveData = newsRepository?.getAllNews("article370")
    }

    fun getNewsRepository(): LiveData<NewsResponse>? {
        return mutableLiveData
    }

    fun temperatureConverter(temp: Int): Any {
        return ConverterUtil.convertCelsiusToFahrenheit(temp)
    }
}