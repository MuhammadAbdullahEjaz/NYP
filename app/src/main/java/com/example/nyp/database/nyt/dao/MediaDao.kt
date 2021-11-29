package com.example.nyp.database.nyt.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.nyp.database.nyt.Media

@Dao
interface MediaDao {
    @Query("SELECT * FROM media WHERE article_id=:id")
    fun getArticleMedia(id:Long):List<Media>

    @Insert
    fun insertMedia(media: Media)

    @Delete
    fun deleteMedia(media: Media)
}
