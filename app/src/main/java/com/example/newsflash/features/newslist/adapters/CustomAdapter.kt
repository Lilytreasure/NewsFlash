package com.example.newsflash.features.newslist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsflash.data.ArticleList
import com.example.newsflash.databinding.ListItemsBinding

class CustomAdapter:ListAdapter<ArticleList ,CustomAdapter.NewsViewHolder> (NewsListComparator()){

    //The general fragment has both a recycler view and a carouselview

    //This adapter will be used  to populate data in the recycler view
    //map the list items view


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding=ListItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem=getItem(position)
        if (currentItem != null){
            holder.bind(currentItem)
        }


    }



    //News viewHolder


    class NewsViewHolder(private val binding:ListItemsBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(articleList:  ArticleList){
            binding.apply {

                textDescription.text=articleList.description
               // textAuthor.text=source.name


                //maPing the image on the imageView using Glide
                val url:String=articleList.urlToImage
                Glide.with(itemView)
                    .load(url)
                    .into(imageView)

            }

        }


    }

    //adding  the comparitor class

    class NewsListComparator: DiffUtil.ItemCallback<ArticleList>(){
        override fun areItemsTheSame(oldItem: ArticleList, newItem: ArticleList)=
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: ArticleList, newItem: ArticleList)=
            oldItem==newItem

    }


}