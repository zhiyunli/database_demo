package com.bc.week8demo2

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ColorDao {
    @Query("SELECT * FROM colors")
    suspend fun getAll(): Array<Color>
    @Insert
    suspend fun insert(vararg color: Color)
    @Update
    suspend fun update(color: Color)
    @Delete
    suspend fun delete(color: Color)

    @Query("SELECT * FROM colors WHERE name = :name")
    fun getColorByName(name: String): LiveData<Color>

    @Query("SELECT * FROM colors WHERE hex_color = :hex")
    fun getColorByHex(hex: String): LiveData<Color>
}