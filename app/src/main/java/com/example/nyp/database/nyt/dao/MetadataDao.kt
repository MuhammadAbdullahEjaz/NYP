package com.example.nyp.database.nyt.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nyp.database.nyt.Metadata

@Dao
interface MediaMetadataDao {
    @Query("SELECT * FROM metadata WHERE media_id=:id")
    fun getMediaMetadata(id:Int)

    @Insert
    fun insertMetaData(mediaMetadata: Metadata)
}