package com.example.newsflash.data

import androidx.room.withTransaction
import com.example.newsflash.api.NewsListApi
import com.example.newsflash.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api: NewsListApi,
    private val db: NewsDatabase,


    ) {

    //populate data from the database

    private val  apiKey:String="5a3e054de1834138a2fbc4a75ee69053"

    private val newsDao=db.newsDao()
    fun getProducts()= networkBoundResource(
        query = {
            newsDao.getNewsFromDatabase()

        },
        fetch = {
            delay(3000)
            api.getNews("us",category = null,apiKey)
        },
        saveFetchResult ={ products->

            //all operations has  to pass or none will be executed
            //To avoid clearing the database  without inserting data

            println(products.body())

            db.withTransaction {
              newsDao.deleteAllProducts()
              newsDao.insertProducts(products)
            }
        }

    )


}