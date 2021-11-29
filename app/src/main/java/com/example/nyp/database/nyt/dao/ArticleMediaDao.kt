package com.example.nyp.database.nyt

import androidx.room.Query

interface ArticleMediaMetadataDao {
    @Query("SELECT md.url FROM media as m, mediametadata as md WHERE m.article_id = :article_id AND m.id=md.media_id AND md.format=\"mediumThreeByTwo440\"")
    fun getMainImageUrl(article_id:Long):String

    @Query("SELECT md.url FROM media as m, mediametadata as md WHERE m.article_id = :article_id AND m.id=md.media_id AND md.format=\"Standard Thumbnail\"")
    fun getThumbnailImageUrl(article_id:Long):String

}