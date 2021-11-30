package com.example.nyp.database.nyt.customdata

import androidx.room.Entity

data class ArticleIdTitleThumbnail(
    val id:Long,
    val title:String,
    val abst:String,
    val url: String
)