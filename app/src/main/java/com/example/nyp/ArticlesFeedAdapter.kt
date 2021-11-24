package com.example.nyp
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nyp.databinding.ArticleFeedViewBinding
import com.example.nyp.network.nyt.Articles
import com.squareup.picasso.Picasso
import java.lang.Exception

class ArticlesFeedAdapter():RecyclerView.Adapter<ArticlesFeedAdapter.ViewHolder>(){

    private var data:List<Articles> = emptyList()

    class ViewHolder(private val binding: ArticleFeedViewBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(article:Articles){
            binding.atitle = article.title

            if(article.media.isNotEmpty()) {
                val picasso = Picasso.get()
                picasso
                    .load(article.media.first().mediaMetadata?.first()?.url)
                    .into(binding.thumbnail, object : com.squareup.picasso.Callback {
                        override fun onSuccess() {
                            Log.d("fetch", "image loaded")
                        }
                        override fun onError(e: Exception?) {
                            Log.d("fetch", "image loading failed ${e}")
                        }
                    })
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
        val binding = ArticleFeedViewBinding.inflate(layout, parent, false)

        binding.root.setOnClickListener{
            val intent = Intent(parent.context, DetailActivity::class.java)

            parent.context.startActivity(intent)
            Log.d("clicked","article clicked")
        }
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = data[position]
        Log.d("fetch","onBinding $article")
        holder.bind(article)
    }

    override fun getItemCount(): Int = data.size

    fun updateArticles(articles:List<Articles>?){
        data = articles ?: emptyList()
        notifyDataSetChanged()
    }
}