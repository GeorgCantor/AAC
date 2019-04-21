package com.georgcantor.aac.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.georgcantor.aac.model.MainRepository
import com.georgcantor.aac.model.data.NewsResponse

class MainViewModel(application: Application) : AndroidViewModel(application) {

    fun getNews(sources: String): LiveData<NewsResponse> {
        return MainRepository.getInstance().getNews(sources)
    }
}