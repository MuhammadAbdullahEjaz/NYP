package com.example.nyp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels{MainViewModelFactory((this.application as MainApplication).repository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.articals_feed)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = viewModel.getData()
        data.observe(this,{list->
            Log.d("fetch","in observer: $list")
            recyclerView.adapter = ArticalsFeedAdapter(list)
        })
    }
}