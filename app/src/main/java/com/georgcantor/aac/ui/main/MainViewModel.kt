package com.georgcantor.aac.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.georgcantor.aac.data.local.entity.FakePost
import com.georgcantor.aac.data.repository.FakePostRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Alex on 06.03.2018.
 *
 * Main view model class that has all the logic of what the main activity/fragment should do
 * and does not contain any UI views.
 */
class MainViewModel @Inject constructor(private val fakePostRepository: FakePostRepository) : ViewModel() {

    var disposable = CompositeDisposable()

    val postLiveList = MutableLiveData<List<FakePost>>()

    val postList: LiveData<List<FakePost>>
        get() = postLiveList

    fun getPostsList(): LiveData<List<FakePost>> {
        disposable.add(fakePostRepository.getFakePosts()
                .subscribe { response -> postLiveList.value = response })

        return postList
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}