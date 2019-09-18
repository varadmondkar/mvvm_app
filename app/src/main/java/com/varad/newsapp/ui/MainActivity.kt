package com.varad.newsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.varad.newsapp.R
import com.varad.newsapp.adapters.NewsAdapter
import com.varad.newsapp.models.NewsArticle
import com.varad.newsapp.models.NewsResponse
import com.varad.newsapp.viewModels.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var articleArrayList: ArrayList<NewsArticle> = ArrayList()
    private var newsAdapter: NewsAdapter? = null
    private var newsViewModel: NewsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        newsViewModel?.init()

        setupRecyclerView()

        newsViewModel?.getNewsRepository()?.observe(this, Observer<NewsResponse> { result ->
            runOnUiThread {
                if (result != null) {
                    val newsArticles = result.articles
                    articleArrayList.addAll(newsArticles)
//                Log.d("NEWS", "List - $articleArrayList")
                    newsAdapter?.notifyDataSetChanged()
                }
            }
        })
    }

    private fun setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = NewsAdapter(this, articleArrayList)
            rvNews.adapter = newsAdapter
            rvNews.layoutManager = LinearLayoutManager(this)
            rvNews.itemAnimator = DefaultItemAnimator()
            rvNews.isNestedScrollingEnabled = true
        } else {
            newsAdapter?.notifyDataSetChanged()
        }
    }
}
