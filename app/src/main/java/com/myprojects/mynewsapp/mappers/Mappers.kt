package com.myprojects.mynewsapp.mappers

import com.myprojects.mynewsapp.data.model.ArticleDTO
import com.myprojects.mynewsapp.domain.model.Article

fun List<ArticleDTO>.toDomain(): List<Article> {
    return map {
        Article(
            title = it.title ?: "",
            description = it.description ?: "",
            content = it.content ?: "",
            urlToImage = it.urlToImage ?: ""
        )
    }
}

