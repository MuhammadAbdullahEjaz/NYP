package com.example.nyp.database.nyt

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(entity = Media::class, parentColumns = ["id"], childColumns = ["media_id"], onDelete = CASCADE)
])
data class MediaMetadata(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val media_id:Int,
    val url:String,
    val format:String,
    val height:Int,
    val width:Int
)
