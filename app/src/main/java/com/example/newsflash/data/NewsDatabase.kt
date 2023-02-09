package com.example.newsflash.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ArticlesList::class], version = 1)
abstract class NewsDatabase : RoomDatabase(){

    abstract  fun newsDao(): NewsDao

}