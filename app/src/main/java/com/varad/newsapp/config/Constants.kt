package com.varad.newsapp.config

/**
 * Created by varad on 2019-08-19
 */
object Constants {

    init {
        System.loadLibrary("native-lib")
    }

    external fun apiKey(): String

    external fun newsApiKey(): String

    const val NEWS_API_KEY = "af44fab1d36349e6b86d9e424225e9b5"
}