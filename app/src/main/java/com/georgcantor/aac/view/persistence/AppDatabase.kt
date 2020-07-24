package com.georgcantor.aac.view.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.georgcantor.aac.view.model.Poster
import com.skydoves.disneymotions.persistence.PosterDao

@Database(entities = [Poster::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun posterDao(): PosterDao
}
