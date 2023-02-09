package com.example.newsflash.features.newslist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsflash.data.NewsList
import com.example.newsflash.databinding.FragmentGeneralBinding
import com.example.newsflash.features.newslist.NewsViewModel
import com.example.newsflash.features.newslist.adapters.CustomAdapter
import com.example.newsflash.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GeneralFragment : Fragment() {

    //adding the viewModel

   private val viewModel: NewsViewModel by viewModels()


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
        var newsList: List<NewsList>

        val newsAdapter=CustomAdapter()

        //Fetch data from the api

      //  val quotesApi = RetrofitHelper.getInstance().create(NewsListApi::class.java)
        // launching a new coroutine
//        GlobalScope.launch {
//            val result = quotesApi.getNews("us",category = null,"5a3e054de1834138a2fbc4a75ee69053")
//            if (result != null)
//            // Checking the results
//                Log.d("Dennis: ", result.body().toString())
//            val  respond= result.body()
//        }






        binding.apply {
            recyclerGeneral.apply {

                adapter=newsAdapter

                layoutManager=LinearLayoutManager(appContext)

            }



            viewModel.products.observe(viewLifecycleOwner){news->

           newsAdapter.submitList(news.data)



                //User error Notifier


                LoadProgress.isVisible =news is Resource.Loading && news.data.isNullOrEmpty()
                TextError.isVisible =news is Resource.Error && news.data.isNullOrEmpty()
                TextError.text=news.error?.localizedMessage



            }


        }

        return  binding.root;


    }


}
