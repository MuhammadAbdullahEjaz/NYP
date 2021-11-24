package com.example.nyp.network.nyt

data class Response(
    val status:String,
    val num_results:Int,
    val results:List<Articles>
)
