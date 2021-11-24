package com.example.nyp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.nyp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels{MainViewModelFactory((this.application as MainApplication).repository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.lifecycleOwner = this
        binding.mainViewModel = viewModel

        setContentView(binding.root)

    }
}