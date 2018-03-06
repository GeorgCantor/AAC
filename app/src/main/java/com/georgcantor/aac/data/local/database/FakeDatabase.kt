package com.georgcantor.aac.data.local.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.georgcantor.aac.data.local.dao.FakePostDao
import com.georgcantor.aac.data.local.entity.FakePost

/**
 * Created by Alex on 06.03.2018.
 */
@Database(entities = arrayOf(FakePost::class), version = 1, exportSchema = false)
abstract class FakeDatabase : RoomDatabase() {

    abstract fun fakePostDao(): FakePostDao
}