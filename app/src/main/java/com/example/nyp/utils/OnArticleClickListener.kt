package com.example.nyp.utils

import com.example.nyp.network.nyt.Articles

interface OnArticleClickListener {
    fun onArticleClicked(article:Articles)
}