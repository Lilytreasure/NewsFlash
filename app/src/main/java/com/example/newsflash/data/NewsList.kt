package com.example.newsflash.data

import androidx.room.Entity


 data class NewsList (
     val status: String,
     val totalResults: Long,
     val articles: List<ArticlesList>
     )


