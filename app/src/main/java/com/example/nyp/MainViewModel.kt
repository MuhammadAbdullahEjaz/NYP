package com.example.nyp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@RequiresApi(Build.VERSION_CODES.N)
class MainViewModel(private val repository: MainRepository):ViewModel() {
    init {
        repository.getThisWeeksPopular()
    }
    private val _networkStatus = repository.getNetWorkStatus()
    val netWorkStatus:LiveData<Boolean>
        get() = _networkStatus

    val data = repository.getData()

}

class MainViewModelFactory(private  val repository: MainRepository):ViewModelProvider.Factory{
    @RequiresApi(Build.VERSION_CODES.N)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }else{
            throw IllegalArgumentException("Unknown viewmodel class")
        }
    }
}

