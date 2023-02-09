package com.example.newsflash.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

@Dao
interface NewsDao {


    @Query(value = "SELECT ALL * FROM  news")
    //Flow will keep emitting data to make appropriate updates
    fun getNewsFromDatabase(): Flow<List<ArticlesList>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertProducts(newsList: Response<NewsList>)

    @Query(value = "DELETE  FROM news")
    suspend fun  deleteAllProducts()




}