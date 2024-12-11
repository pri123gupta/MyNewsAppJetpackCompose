package com.myprojects.mynewsapp.domain.repo

import com.myprojects.mynewsapp.domain.model.Article

interface NewsRepo {
    suspend fun getNewsArticles(): List<Article>
}