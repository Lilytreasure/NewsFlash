package com.example.newsflash.features.newslist.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsflash.api.NewsListApi
import com.example.newsflash.api.RetrofitHelper
import com.example.newsflash.databinding.FragmentGeneralBinding
import com.example.newsflash.features.newslist.adapters.CustomAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GeneralFragment : Fragment() {

    //adding the viewModel

   //private val viewModel: NewsViewModel by viewModels()


    //find the recycler view and map the custom adapter
     // populate the data
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val appContext = requireContext().applicationContext!!

        val binding = FragmentGeneralBinding.inflate(inflater,container,false)

        //map the recycler view
        //set the recycler view and the custom adapter

        val newsAdapter=CustomAdapter()

        //Fetch data from the api

        val quotesApi = RetrofitHelper.getInstance().create(NewsListApi::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getNews("us",category = null,"5a3e054de1834138a2fbc4a75ee69053")
            if (result != null)
            // Checking the results
                Log.d("Dennis: ", result.body().toString())
        }




        binding.apply {
            recyclerGeneral.apply {

                adapter=newsAdapter

                layoutManager=LinearLayoutManager(appContext)

            }

//
//          viewModel.news.observe(viewLifecycleOwner){news->
//
//           //newsAdapter.submitList(news)
//
//       }


        }

        return  binding.root;


    }


}