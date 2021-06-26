package com.example.newsappdemo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsappdemo.R
import com.example.newsappdemo.model.NewsData

/**
 * Created by Manasa on 26,June,2021
 */
class NewsAdapter(private var newsList: List<NewsData>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(layoutInflater.inflate(R.layout.news_item, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.title.text = news.title
        holder.content.text = news.content
        holder.description.text = news.description
        holder.linkvalue.text = news.url

    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun submitList(itemsList: List<NewsData>) {
        val newData = itemsList
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return newsList.size
            }

            override fun getNewListSize(): Int {
                return newData.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return newsList[oldItemPosition].title == newData[newItemPosition].title
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return newsList[oldItemPosition] == newData[newItemPosition]
            }

        }).dispatchUpdatesTo(this)
        newsList = newData
    }

    class NewsViewHolder(itemView: View): ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.title)
        val content = itemView.findViewById<TextView>(R.id.content)
        val description = itemView.findViewById<TextView>(R.id.description)
        val linkvalue = itemView.findViewById<TextView>(R.id.linkValue)
    }
}