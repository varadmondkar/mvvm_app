package com.varad.newsapp.models

/**
 * Created by varad on 2019-08-19
 */
data class NewsArticle(
        val source: NewsSource? = null,
        val author: String = "",
        val title: String = "",
        val description: String = "",
        val url: String = "",
        val urlToImage: String = "",
        val publishedAt: String = "",
        val content: String = ""
)