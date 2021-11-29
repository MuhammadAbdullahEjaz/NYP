package com.example.nyp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nyp.databinding.ActivityDetailBinding
import com.example.nyp.network.nyt.Article

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        val intent = this.intent
        binding.article = intent.extras?.get("article") as Article

        setContentView(binding.root)

    }
}