package com.myprojects.mynewsapp.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myprojects.mynewsapp.domain.usecase.NewsArticleUsecase
import com.myprojects.mynewsapp.presentation.HomeStateHolder
import com.myprojects.mynewsapp.utils.NewsResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsUsecase: NewsArticleUsecase

) : ViewModel() {
    val articles: MutableState<HomeStateHolder> = mutableStateOf(HomeStateHolder())
init {
    getNewsArticles()
}

    fun getNewsArticles() {
        newsUsecase().onEach {
            when (it) {
                is NewsResource.Loading -> {
                    articles.value = HomeStateHolder(isLoading = true)
                }

                is NewsResource.Success -> {
                    articles.value = HomeStateHolder(data = it.data)
                }

                is NewsResource.Error -> {
                    articles.value = HomeStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}