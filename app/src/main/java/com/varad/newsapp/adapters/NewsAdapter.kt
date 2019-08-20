package com.varad.newsapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.size.Scale
import com.squareup.picasso.Picasso
import com.varad.newsapp.R
import com.varad.newsapp.models.NewsArticle


/**
 * Created by varad on 2019-08-19
 */
class NewsAdapter(private var context: Context, private var articles: ArrayList<NewsArticle>)
    : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        val article = articles[position]
        Log.d("NEWS", "List - $position - ${article.title}")
        holder.tvName.text = article.title
        holder.tvDescription.text = article.description
//        Picasso.get().load(article.urlToImage).into(holder.ivNews)
        holder.ivNews.load(article.urlToImage) {
            placeholder(R.color.material_grey_300)
            scale(Scale.FILL)
        }
    }

    override fun getItemCount(): Int = articles.size

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tvName: TextView = itemView.findViewById(R.id.tvName)
        internal var tvDescription: TextView = itemView.findViewById(R.id.tvDesCription)
        internal var ivNews: ImageView = itemView.findViewById(R.id.ivNews)

    }
}