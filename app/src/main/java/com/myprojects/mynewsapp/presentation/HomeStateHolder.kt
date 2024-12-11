package com.myprojects.mynewsapp.presentation

import com.myprojects.mynewsapp.domain.model.Article

data class HomeStateHolder(
    val isLoading: Boolean = false,
    val data: List<Article>? = null,
    val error: String = ""
)
