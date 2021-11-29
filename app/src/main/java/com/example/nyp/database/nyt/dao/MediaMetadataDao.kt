package com.example.nyp.database.nyt.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nyp.database.nyt.MediaMetadata

@Dao
interface MediaMetadataDao {
    @Query("SELECT * FROM mediametadata WHERE media_id=:id")
    fun getMediaMetadata(id:Int)

    @Insert
    fun insertMetaData(mediaMetadata: MediaMetadata)
}