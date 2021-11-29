package com.example.nyp
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nyp.databinding.ArticleFeedViewBinding
import com.example.nyp.network.nyt.Article
import com.example.nyp.utils.OnArticleClickListener

class ArticlesFeedAdapter(private val onArticleClickListener: OnArticleClickListener):RecyclerView.Adapter<ArticlesFeedAdapter.ViewHolder>(){

    private var data:List<Article> = emptyList()

    class ViewHolder(private val binding: ArticleFeedViewBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(article:Article, articleClickListner: OnArticleClickListener){
            binding.article = article
            binding.root.setOnClickListener{
                articleClickListner.onArticleClicked(article)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
        val binding = ArticleFeedViewBinding.inflate(layout, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = data[position]
        Log.d("fetch","onBinding $article")
        holder.bind(article,onArticleClickListener)
    }

    override fun getItemCount(): Int = data.size

    fun updateArticles(articles:List<Article>?){
        data = articles ?: emptyList()
        notifyDataSetChanged()
    }
}