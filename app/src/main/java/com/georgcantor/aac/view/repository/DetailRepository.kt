package com.georgcantor.aac.view.repository

import androidx.databinding.ObservableBoolean
import com.georgcantor.aac.view.persistence.PosterDao

class DetailRepository constructor(private val posterDao: PosterDao) : Repository {

    override var isLoading = ObservableBoolean(false)

    fun getPosterById(id: Long) = posterDao.getPoster(id)
}
