package com.varad.newsapp.networking

import com.varad.newsapp.config.EndPoints
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


/**
 * Created by varad on 2019-08-19
 */
object RetrofitService {

    private val retrofit = Retrofit.Builder()
            .baseUrl(EndPoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }

}