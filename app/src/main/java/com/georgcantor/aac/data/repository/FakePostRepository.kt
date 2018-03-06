package com.georgcantor.aac.data.repository

import com.georgcantor.aac.data.local.dao.FakePostDao
import com.georgcantor.aac.data.local.entity.FakePost
import com.georgcantor.aac.data.remote.FakeApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Alex on 06.03.2018.
 *
 * this is a manager class that handles all the api calls and updates the database
 */
class FakePostRepository @Inject constructor(private val fakeApiService: FakeApiService,
                                             private val fakePostDao: FakePostDao) {

    fun getFakePosts(): Single<List<FakePost>> {
        return fakeApiService.getFakePosts().onErrorResumeNext {
            fakePostDao.getPostsFromDB()
        }.doOnSuccess {
                    fakePostDao.insertFakePosts(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}