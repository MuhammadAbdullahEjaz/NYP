package com.example.nyp.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nyp.ArticlesFeedAdapter
import com.example.nyp.network.nyt.Article
import com.example.nyp.network.nyt.Media
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.lang.Exception


//Adapter to feed recycler view
@BindingAdapter("articlesData")
fun bindArticleViewModel(recyclerView: RecyclerView, data:List<Article>?){
    val adapter = recyclerView.adapter as ArticlesFeedAdapter
    adapter.updateArticles(data)
}

//BindingAdapter for CircularImageView
@BindingAdapter("android:setImage")
fun bindSetImage(circleImageView: CircleImageView, media:List<Media>){
    if(media.isNotEmpty()) {
        val picasso = Picasso.get()
        picasso
            .load(media.first().mediaMetadata?.first()?.url)
            .into(circleImageView, object : com.squareup.picasso.Callback {
                override fun onSuccess() {
                    Log.d("fetch", "image loaded")
                }

                override fun onError(e: Exception?) {
                    Log.d("fetch", "image loading failed ${e}")
                }
            })
    }
}

//Adapter for ImageView
@BindingAdapter("android:setImage")
fun bindSetImage(imageView: ImageView, media:List<Media>){
    if(media.isNotEmpty()) {
        val picasso = Picasso.get()
        picasso
            .load(media.first().mediaMetadata?.get(2)?.url)
            .into(imageView, object : com.squareup.picasso.Callback {
                override fun onSuccess() {
                    Log.d("fetch", "image loaded")
                }

                override fun onError(e: Exception?) {
                    Log.d("fetch", "image loading failed ${e}")
                }
            })
    }
}

//Adapter to set visibility of a TextView
@BindingAdapter("android:visibility")
fun setVisibility(textView: TextView, visible:Boolean){
    textView.visibility = if(!visible) View.VISIBLE else View.GONE
}