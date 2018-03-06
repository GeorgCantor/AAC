package com.georgcantor.aac.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.georgcantor.aac.data.local.entity.FakePost
import io.reactivex.Single

/**
 * Created by Alex on 06.03.2018.
 */
@Dao
abstract class FakePostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertFakePosts(postsList: List<FakePost>)

    @Query("SELECT * FROM posts")
    abstract fun getPostsFromDB(): Single<List<FakePost>>
}