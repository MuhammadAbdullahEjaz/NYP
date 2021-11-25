package com.example.nyp.network.nyt

import java.io.Serializable

data class MediaMetadata(
    val url:String,
    val format:String,
    val height:Int,
    val width:Int
):Serializable
