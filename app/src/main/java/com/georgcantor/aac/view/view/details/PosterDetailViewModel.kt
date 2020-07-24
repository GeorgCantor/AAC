package com.georgcantor.aac.view.view.details

import com.georgcantor.aac.view.base.LiveCoroutinesViewModel
import com.georgcantor.aac.view.repository.DetailRepository

class PosterDetailViewModel(private val repository: DetailRepository) : LiveCoroutinesViewModel() {

    fun getPoster(id: Long) = repository.getPosterById(id)
}
