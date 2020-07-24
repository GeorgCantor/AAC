package com.georgcantor.aac.view.view.main

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.georgcantor.aac.view.base.LiveCoroutinesViewModel
import com.georgcantor.aac.view.model.Poster
import com.georgcantor.aac.view.repository.MainRepository

class MainViewModel constructor(private val mainRepository: MainRepository) : LiveCoroutinesViewModel() {

    private var posterFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val posterListLiveData: LiveData<List<Poster>>

    val isLoading: ObservableBoolean = mainRepository.isLoading
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        this.posterListLiveData = this.posterFetchingLiveData.switchMap {
            launchOnViewModelScope {
                this.mainRepository.loadDisneyPosters { this.toastLiveData.postValue(it) }
            }
        }
    }

    fun fetchDisneyPosterList() = this.posterFetchingLiveData.postValue(true)
}
