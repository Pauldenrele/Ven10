package com.example.venten.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.venten.models.CarOwners
import com.example.venten.models.VenModel
import com.example.venten.data.database.CarOwnersDao


class CarOwnersRepository(private val carOwnersDao: CarOwnersDao) {


      fun getByFilter(venModel: VenModel)
              = carOwnersDao
          .getCarOwnersByFilters(
              venModel.gender,
              venModel.startYear,
              venModel.endYear,
              venModel.countries,
              venModel.colors)



    suspend fun insertCarOwner(carOwners: List<CarOwners>) {
        carOwnersDao.insertCarOwner(carOwners)
    }


}
