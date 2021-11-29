package com.example.nyp.database.nyt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.example.nyp.network.nyt.MediaMetadata

@Entity(foreignKeys = [ForeignKey(entity = Article::class, parentColumns =  ["id"], childColumns =  ["article_id"], onDelete = CASCADE)])
data class Media(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val article_id:Long,
    val type:String,
    val subType:String?,
    val caption:String?,
)
