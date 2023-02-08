package com.example.newsflash.features.newslist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsflash.data.ArticlesList
import com.example.newsflash.data.NewsList
import com.example.newsflash.databinding.ListItemsBinding

class CustomAdapter:ListAdapter<ArticlesList ,CustomAdapter.NewsViewHolder> (NewsListComparator()){

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

        fun bind(articleList:  ArticlesList){
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

    class NewsListComparator: DiffUtil.ItemCallback<ArticlesList>(){
        override fun areItemsTheSame(oldItem: ArticlesList, newItem: ArticlesList)=
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: ArticlesList, newItem: ArticlesList)=
            oldItem==newItem

    }


}