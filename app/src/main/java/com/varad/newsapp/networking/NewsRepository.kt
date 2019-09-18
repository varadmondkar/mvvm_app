package com.varad.newsapp.networking

import com.varad.newsapp.models.NewsResponse
import androidx.lifecycle.MutableLiveData
import com.varad.newsapp.config.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by varad on 2019-08-19
 */
class NewsRepository {

    companion object {

//        var API_KEY = Constants.NEWS_API_KEY
        var API_KEY = Constants.newsApiKey()

        private var newsRepository: NewsRepository? = null

        val instance: NewsRepository
            get() {
                if (newsRepository == null) {
                    newsRepository = NewsRepository()
                }
                return newsRepository as NewsRepository
            }
    }

    private val newsApi: NewsApi = RetrofitService.createService(NewsApi::class.java)

    fun getAllNews(source: String): MutableLiveData<NewsResponse> {
        val newsData = MutableLiveData<NewsResponse>()
        newsApi.getAllNewsList(source, API_KEY).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    newsData.value = response.body()
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                newsData.value = null
            }
        })
        return newsData
    }

    fun getNews(source: String): MutableLiveData<NewsResponse> {
        val newsData = MutableLiveData<NewsResponse>()
        newsApi.getNewsList(source, API_KEY).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    newsData.value = response.body()
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                newsData.value = null
            }
        })
        return newsData
    }
}