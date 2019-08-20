package com.varad.newsapp.models

/**
 * Created by varad on 2019-08-19
 */
data class NewsResponse(
        val status: String = "",
        val totalResults: Int = 0,
        val articles: List<NewsArticle> = arrayListOf()
)