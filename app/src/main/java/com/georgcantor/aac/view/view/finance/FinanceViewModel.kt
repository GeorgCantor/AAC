package com.georgcantor.aac.view.view.finance

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgcantor.aac.view.model.Article
import com.georgcantor.aac.view.repository.Repository
import kotlinx.coroutines.launch

class FinanceViewModel(private val repository: Repository) : ViewModel() {

    val articles = MutableLiveData<List<Article>>()
    val searchArticles = MutableLiveData<List<Article>>()
    val isLoading = MutableLiveData<Boolean>()
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = repository.getNews("finance", 1)
            articles.postValue(response.body()?.articles)
            isLoading.postValue(false)
        }
    }

    fun search(query: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = repository.getNews(query, 1)
            searchArticles.postValue(response.body()?.articles)
            isLoading.postValue(false)
        }
    }
}
