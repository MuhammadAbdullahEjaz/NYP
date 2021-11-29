package com.example.nyp.utils

import com.example.nyp.network.nyt.Article

interface OnArticleClickListener {
    fun onArticleClicked(article:Article)
}