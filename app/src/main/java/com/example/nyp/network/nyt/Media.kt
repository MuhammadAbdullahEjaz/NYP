package com.example.nyp.network.nyt

import com.squareup.moshi.Json
import java.io.Serializable

data class Media(
    val type:String,
    val subType:String?,
    val caption:String?,
    @Json(name = "media-metadata") val mediaMetadata:List<MediaMetadata>?
):Serializable
