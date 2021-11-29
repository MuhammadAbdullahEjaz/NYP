package com.example.nyp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nyp.database.nyt.Article
import com.example.nyp.database.nyt.ArticleMediaMetadataDao
import com.example.nyp.database.nyt.Media
import com.example.nyp.database.nyt.MediaMetadata
import com.example.nyp.database.nyt.dao.ArticleDao
import com.example.nyp.database.nyt.dao.MediaDao
import com.example.nyp.database.nyt.dao.MediaMetadataDao

@Database(entities = [Article::class, Media::class, MediaMetadata::class], version = 1)
abstract class NytDatabase : RoomDatabase() {
    abstract fun articleDao() : ArticleDao
    abstract  fun mediaDao() : MediaDao
    abstract fun metadataDao() : MediaMetadataDao
    abstract fun articleMediaDao() : ArticleMediaMetadataDao

    companion object{
        private var INSTANCE:NytDatabase? = null

        fun getDatabase(context:Context):NytDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NytDatabase::class.java,
                    "nyt_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}