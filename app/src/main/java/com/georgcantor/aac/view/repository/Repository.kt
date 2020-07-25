package com.georgcantor.aac.view.repository

import com.georgcantor.aac.view.network.ApiService

class Repository constructor(private val apiService: ApiService) {

    suspend fun getNews(query: String, page: Int) = apiService.getNews(query, page)
}
