package com.georgcantor.aac.view.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgcantor.aac.view.model.Poster
import com.georgcantor.aac.view.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val posterListLiveData = MutableLiveData<List<Poster>>()

    val isLoading = MutableLiveData<Boolean>()
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = mainRepository.getPosters()
            posterListLiveData.postValue(response.body())
            isLoading.postValue(false)
        }
    }
}
