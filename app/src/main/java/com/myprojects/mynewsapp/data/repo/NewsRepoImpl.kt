package com.myprojects.mynewsapp.data.repo

import com.myprojects.mynewsapp.data.model.ArticleDTO
import com.myprojects.mynewsapp.data.model.NewsDTO
import com.myprojects.mynewsapp.data.network.APIService
import com.myprojects.mynewsapp.domain.model.Article
import com.myprojects.mynewsapp.domain.repo.NewsRepo
import com.myprojects.mynewsapp.mappers.toDomain
import retrofit2.Response
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(
    private val apiService: APIService
) : NewsRepo {
    override suspend fun getNewsArticles(): List<Article> {
        val res: Response<NewsDTO> = apiService.getNews()
        val res2: List<ArticleDTO>? = apiService.getNews().body()?.articles
        return res2?.toDomain()!!
    }
}


