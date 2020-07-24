package com.georgcantor.aac.view.repository

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.georgcantor.aac.view.model.Poster
import com.georgcantor.aac.view.network.DisneyService
import com.georgcantor.aac.view.persistence.PosterDao
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import com.skydoves.sandwich.request
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository constructor(
        private val disneyService: DisneyService,
        private val posterDao: PosterDao
) : Repository {

    override var isLoading = ObservableBoolean(false)

    suspend fun loadDisneyPosters(error: (String) -> Unit) = withContext(Dispatchers.IO) {
        val liveData = MutableLiveData<List<Poster>>()
        val posters = posterDao.getPosterList()

        if (posters.isEmpty()) {
            isLoading.set(true)
            disneyService.fetchDisneyPosterList().request { apiResponse ->
                apiResponse.onSuccess {
                    data.whatIfNotNull {
                        liveData.postValue(it)
                        posterDao.insertPosterList(it)
                    }
                }
                        .onError {
                            error(message())
                        }
                        .onException {
                            error(message())
                        }
                isLoading.set(false)
            }
        }

        liveData.apply { postValue(posters) }
    }
}
