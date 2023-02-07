package com.example.newsflash.features.newslist.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsflash.features.newslist.fragments.GeneralFragment
import com.example.newsflash.util.Constants.TOTAL_NEWS_TAB

class FragmentAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle){

    override fun getItemCount(): Int = TOTAL_NEWS_TAB

    override fun createFragment(position: Int): Fragment {

        when (position) {
            0 -> {
                return GeneralFragment()
            }
            1 -> {
                return GeneralFragment()
            }
            2 -> {
                return GeneralFragment()
            }
            3 -> {
                return GeneralFragment()
            }
            4 -> {
                return GeneralFragment()
            }
            5 -> {
                return GeneralFragment()
            }
            6 -> {
                return GeneralFragment()
            }

            else -> return GeneralFragment()

        }
    }
}