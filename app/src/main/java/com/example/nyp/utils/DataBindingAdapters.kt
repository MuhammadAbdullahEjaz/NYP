package com.example.nyp.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nyp.ArticlesFeedAdapter
import com.example.nyp.network.nyt.Articles

@BindingAdapter("articlesData")
fun bindArticleViewModel(recyclerView: RecyclerView, data:List<Articles>?){
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateArticles(data)
}

private fun getOrCreateAdapter(recyclerView: RecyclerView):ArticlesFeedAdapter{
    return if(recyclerView.adapter != null && recyclerView.adapter is ArticlesFeedAdapter){
            recyclerView.adapter as ArticlesFeedAdapter
    }else{
        val articleFeedAdapter = ArticlesFeedAdapter()
        recyclerView.adapter = articleFeedAdapter
        articleFeedAdapter
    }
}