package com.example.newsflash.features.newslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsflash.util.Constants.ENTERTAINMENT
import com.example.newsflash.util.Constants.HEALTH
import com.example.newsflash.util.Constants.HOME
import com.example.newsflash.util.Constants.SCIENCE
import com.example.newsflash.util.Constants.SPORTS
import com.example.newsflash.util.Constants.TECHNOLOGY
import com.example.newsflash.databinding.ActivityNewsBinding
import com.example.newsflash.features.newslist.adapters.FragmentAdapter
import com.example.newsflash.util.Constants.BUSINESS
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val newsCategories = arrayOf(
        HOME, BUSINESS,HEALTH,
         SCIENCE,ENTERTAINMENT,
       TECHNOLOGY,  SPORTS
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //swich between different fragments
        //map the tablayouts

        val fragmentAdapter=FragmentAdapter(supportFragmentManager,lifecycle)


        binding.apply {
            MainViewPager.apply {
                adapter=fragmentAdapter

            }


        }


        TabLayoutMediator(binding.tabsLayout, binding.MainViewPager) { tab, position ->
            tab.text = newsCategories[position]
        }.attach()


 //End of  the onCreate method
    }
}