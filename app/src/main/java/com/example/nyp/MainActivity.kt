package com.example.nyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.nyp.databinding.ActivityMainBinding
import com.example.nyp.network.nyt.Articles
import com.example.nyp.utils.OnArticleClickListener

class MainActivity : AppCompatActivity(), OnArticleClickListener {

    private val viewModel:MainViewModel by viewModels{MainViewModelFactory((this.application as MainApplication).repository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.mainViewModel = viewModel
        binding.articlesFeed.adapter = ArticlesFeedAdapter(this)
        setContentView(binding.root)

    }

    override fun onArticleClicked(article: Articles) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("article",article)
        this.startActivity(intent)
    }
}