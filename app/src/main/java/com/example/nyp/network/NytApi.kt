package com.example.nyp.network

import com.example.nyp.network.nyt.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NytApi {
    @GET("viewed/7.json")
    fun thisWeeksPopular(@Query("api-key") key:String):Call<Response>
}