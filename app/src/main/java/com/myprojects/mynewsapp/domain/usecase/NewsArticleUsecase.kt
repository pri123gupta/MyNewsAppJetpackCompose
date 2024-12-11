package com.myprojects.mynewsapp.domain.usecase

import com.myprojects.mynewsapp.domain.model.Article
import com.myprojects.mynewsapp.domain.repo.NewsRepo
import com.myprojects.mynewsapp.utils.NewsResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsArticleUsecase @Inject constructor(
    private val repo: NewsRepo
) {


    operator fun invoke(): Flow<NewsResource<List<Article>>> = flow {
        emit(NewsResource.Loading(""))
        try {

            emit(NewsResource.Success(repo.getNewsArticles()))

        } catch (e: Exception) {
            emit(NewsResource.Error(e.message))
        }
    }
}