package com.georgcantor.aac.view.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgcantor.aac.view.model.Article
import com.georgcantor.aac.view.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel constructor(private val repository: Repository) : ViewModel() {

    val articles = MutableLiveData<List<Article>>()

    val isLoading = MutableLiveData<Boolean>()
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = repository.getNews("bmw", 1)
            articles.postValue(response.body()?.articles)
            isLoading.postValue(false)
        }
    }
}
