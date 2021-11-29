package com.example.nyp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.nyp.databinding.ActivityMainBinding
import com.example.nyp.network.nyt.Article
import com.example.nyp.utils.OnArticleClickListener

class MainActivity : AppCompatActivity(), OnArticleClickListener {

    private val viewModel:MainViewModel by viewModels{MainViewModelFactory((this.application as MainApplication).repository)}

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.mainViewModel = viewModel
        binding.articlesFeed.adapter = ArticlesFeedAdapter(this)
        setContentView(binding.root)
    }

    override fun onArticleClicked(article: Article) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("article",article)
        this.startActivity(intent)
    }
}