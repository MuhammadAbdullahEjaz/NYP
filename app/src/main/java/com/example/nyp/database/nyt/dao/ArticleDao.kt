package com.example.nyp.database.nyt.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.nyp.database.nyt.Article

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun getAllArticles(): List<Article>

    @Query("SELECT * FROM article WHERE id=:id")
    fun getArticle(id:Long): Article

    @Insert
    fun insertArticles(vararg articles: Article)

    @Insert
    fun insertArticle(article: Article)

    @Delete
    fun delete(article: Article)

    @Query("DELETE FROM article WHERE id=:id")
    fun deleteArticleById(id:Long)

}