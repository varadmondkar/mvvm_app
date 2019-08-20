package com.varad.newsapp.networking

import com.varad.newsapp.config.EndPoints
import com.varad.newsapp.models.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by varad on 2019-08-19
 */
interface NewsApi {
    @GET(EndPoints.EVERYTHING)
    fun getAllNewsList(
            @Query("q") q: String,
            @Query("apiKey") apiKey: String,
            @Query("pageSize") pageSize: Int = 100
    ): Call<NewsResponse>

    @GET(EndPoints.TOP_HEADLINES)
    fun getNewsList(
            @Query("sources") newsSource: String,
            @Query("apiKey") apiKey: String
    ): Call<NewsResponse>
}