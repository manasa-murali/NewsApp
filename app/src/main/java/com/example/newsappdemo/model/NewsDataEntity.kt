package com.example.newsappdemo.model


import com.google.gson.annotations.SerializedName

data class NewsDataEntity(
    @SerializedName("articles")
    val articles: List<Article?>? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null
) {
    data class Article(
        @SerializedName("author")
        val author: String? = null,
        @SerializedName("content")
        val content: String? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("publishedAt")
        val publishedAt: String? = null,
        @SerializedName("source")
        val source: Source? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("url")
        val url: String? = null,
        @SerializedName("urlToImage")
        val urlToImage: String? = null
    ) {
        data class Source(
            @SerializedName("id")
            val id: String? = null,
            @SerializedName("name")
            val name: String? = null
        )
    }
}