package com.example.nyp.database.nyt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nyp.network.nyt.Media

@Entity
data class Article(
    @PrimaryKey val id:Long,
    val url:String,
    val title:String,
    val abstract:String,
    @ColumnInfo(name="published_date") val publishedDate:String,
    val uri:String
)
