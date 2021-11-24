package com.example.nyp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nyp.network.nyt.Articles
import com.example.nyp.network.nyt.NytApi
import com.example.nyp.network.nyt.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainRepository {
    private var nytApiService:NytApi
    private val data = MutableLiveData<List<Articles>>()
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    init {
        nytApiService = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/")
            .build()
            .create(NytApi::class.java)
    }
    fun getThisWeeksPopular(){
        nytApiService.thisWeeksPopular("eGFyBgIusGngCgwhiDQ5210LhPy7tMAT").enqueue(
            object: Callback<Response>{
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    Log.d("resp","onSucess: ${response.body()}")
                    data.postValue(response.body()?.results)
                }

                override fun onFailure(call: Call<Response>, t: Throwable) {
                    Log.d("resp","onFailure: ${t.message}")
                }

            }
        )
    }
    fun getData():MutableLiveData<List<Articles>>{
        return data
    }
}