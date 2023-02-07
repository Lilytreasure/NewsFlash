package com.example.newsflash.features.newslist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsflash.databinding.FragmentGeneralBinding
import com.example.newsflash.features.newslist.adapters.CustomAdapter

class GeneralFragment : Fragment() {


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

        binding.apply {
            recyclerGeneral.apply {

                adapter=newsAdapter

                layoutManager=LinearLayoutManager(appContext)


            }

        }

        return  binding.root;


    }


}