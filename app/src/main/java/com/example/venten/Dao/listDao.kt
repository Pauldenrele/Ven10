package com.example.venten.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.venten.Model.venModel
import com.example.venten.Model.venModelResp


@Dao
interface listDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setList(listCars: List<venModelResp>)

    @Query("SELECT * from " + venModelResp.TABLE_NAME)
     fun getList(): LiveData<List<venModelResp>>
}