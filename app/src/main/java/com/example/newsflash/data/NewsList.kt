package com.example.newsflash.data

 data class NewsList (
     val status: String,
     val totalResults: Long,
     val articles: List<ArticleList>
     )


