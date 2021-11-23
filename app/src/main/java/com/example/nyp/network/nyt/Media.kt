package com.example.nyp.network.nyt

import com.squareup.moshi.Json

data class Media(
    val type:String,
    val subType:String?,
    val caption:String?,
    @Json(name = "media-metadata") val mediaMetadata:List<MediaMetadata>?
)
