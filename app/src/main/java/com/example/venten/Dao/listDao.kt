package com.example.venten.Dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.venten.Model.venModel

interface listDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setList(listCars: venModel)

    @Query("SELECT * from list_table ORDER BY id ASC")
    fun getList(): LiveData<List<venModel>>
}