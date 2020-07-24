/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
