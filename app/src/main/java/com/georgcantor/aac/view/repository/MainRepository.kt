package com.georgcantor.aac.view.repository

import com.georgcantor.aac.view.network.DisneyService

class MainRepository constructor(private val disneyService: DisneyService) {

    suspend fun getPosters() = disneyService.getPosters()
}
