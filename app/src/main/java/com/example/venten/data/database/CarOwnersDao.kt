package com.example.venten.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.venten.models.CarOwners

@Dao
interface CarOwnersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCarOwner(carOwners: List<CarOwners>)



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCarOwner(carOwners: CarOwners)


    @Query("SELECT * FROM car_owners WHERE gender == :gender AND country IN (:countries) AND car_color IN (:color)  AND car_model >= :startYear AND car_model <= :endYear ")
    fun getCarOwnersByFilters(gender : String,
                                      startYear : Int?,
                                      endYear : Int?,
                                      countries: List<String>?,
                                      color: List<String>?


    ): LiveData<List<CarOwners>>
}