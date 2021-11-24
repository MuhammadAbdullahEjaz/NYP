package com.example.nyp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nyp.network.nyt.Articles

class MainViewModel(private val repository: MainRepository):ViewModel() {
    init {
        repository.getThisWeeksPopular()
    }
    val data = repository.getData()

}

class MainViewModelFactory(private  val repository: MainRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }else{
            throw IllegalArgumentException("Unknown viewmodel class")
        }
    }
}

