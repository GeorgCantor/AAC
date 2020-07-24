package com.georgcantor.aac.view.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.georgcantor.aac.view.model.Poster

@Dao
interface PosterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosterList(posters: List<Poster>)

    @Query("SELECT * FROM Poster WHERE id = :id")
    fun getPoster(id: Long): Poster

    @Query("SELECT * FROM Poster")
    fun getPosterList(): List<Poster>
}
