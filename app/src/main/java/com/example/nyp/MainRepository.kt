package com.example.nyp

import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.example.nyp.network.nyt.Article
import com.example.nyp.network.NytApi
import com.example.nyp.network.nyt.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainRepository(private val connectivityManager: ConnectivityManager) {
    private var nytApiService: NytApi
    private val data = MutableLiveData<List<Article>>()
    private val networkStatus: MutableLiveData<Boolean> = MutableLiveData(true)
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

    fun getThisWeeksPopular() {
        nytApiService.thisWeeksPopular("eGFyBgIusGngCgwhiDQ5210LhPy7tMAT").enqueue(
            object : Callback<Response> {
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    if (response.code() == 200) {
                        data.postValue(response.body()?.results)
                    }
                }

                @RequiresApi(Build.VERSION_CODES.N)
                override fun onFailure(call: Call<Response>, t: Throwable) {
                    networkStatus.postValue(false)
                    onNetWorkAvailable()
                }

            }
        )
    }

    fun getData(): MutableLiveData<List<Article>> {
        return data
    }

    fun getNetWorkStatus(): MutableLiveData<Boolean> {
        return networkStatus
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun onNetWorkAvailable() {
        connectivityManager.registerDefaultNetworkCallback(object :
            ConnectivityManager.NetworkCallback() {
            override fun onLost(network: Network) {
                super.onLost(network)
                networkStatus.postValue(false)
            }

            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                networkStatus.postValue(true)
                getThisWeeksPopular()
                connectivityManager.unregisterNetworkCallback(this)
            }
        })
    }
}