package com.example.nyp.network.nyt

import com.squareup.moshi.Json

data class Articles(
    val id:Long,
    val url:String,
    val title:String,
    val abstract:String,
    @Json(name = "published_date")val publishedDate:String,
    val media:List<Media>,
    val uri:String
)
