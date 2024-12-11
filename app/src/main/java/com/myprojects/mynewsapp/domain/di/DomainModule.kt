package com.myprojects.mynewsapp.domain.di

import com.myprojects.mynewsapp.data.network.APIService
import com.myprojects.mynewsapp.data.repo.NewsRepoImpl
import com.myprojects.mynewsapp.domain.repo.NewsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideNewsRepo(apiService: APIService): NewsRepo {
        return NewsRepoImpl(apiService)
    }
}