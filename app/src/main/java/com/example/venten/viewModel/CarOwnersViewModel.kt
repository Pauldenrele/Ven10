package com.example.venten.viewModel

import android.app.Application
import android.os.Environment
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.venten.models.CarOwners
import com.example.venten.models.VenModel
import com.example.venten.repository.CarOwnersRepository
import com.example.venten.data.database.CarOwnersDatabase
import com.example.venten.data.remote.RetrofitService
import com.opencsv.CSVReader
import kotlinx.coroutines.*
import java.io.File
import java.io.FileReader
import java.util.concurrent.Executors

class CarOwnersViewModel(application: Application): AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    private val _listOfCarOwners = MutableLiveData<List<CarOwners>>()
    val listOfCarOwners : LiveData<List<CarOwners>>
        get() = _listOfCarOwners


    private val _progress = MutableLiveData<Boolean>()
    val progress : LiveData<Boolean>
        get() = _progress



    private val repository: CarOwnersRepository

    init {
        val carOwnersDao = CarOwnersDatabase.getInstance(application,uiScope).carOwnersDao()
        repository =  CarOwnersRepository(carOwnersDao)
        insert()
    }



    fun getCarOwnersByFilter(venModel: VenModel):LiveData<List<CarOwners>> {
        _progress.value = false
        return repository.getByFilter(venModel)
    }


    private fun insert() {
        Executors.newSingleThreadScheduledExecutor()
            .execute(Runnable {
                var row: Array<String>? = null

                val csvfile =
                    File(Environment.getExternalStorageDirectory().toString() + "/car_ownsers_data.csv")

                val csvReader = CSVReader(FileReader(csvfile))
                val content = csvReader.readAll()

                for (`object` in content) {
                    row = `object` as Array<String>


                    Log.v(
                        "Datarr",
                        row[0] + row[1] + "#" + row[2] + "#" + row[3] + "#" + row[4] + "#" + row[5] + "#" + row[6] + "#" + row[7] + "#" + row[8] + "#" + row[9] + "#" + row[10]
                    )

                    val c = mutableListOf<CarOwners>()

                    c.add(CarOwners(
                      Integer.parseInt(row[0])  ,row[1],row[2],row[3],row[4]
                        ,Integer.parseInt(row[5]),row[6],row[7],row[8],row[9]
                    ))


                }

                csvReader.close()


            })




        val c = mutableListOf<CarOwners>()


        c.add(CarOwners(


            1,"wilson","jack","email","",1980,
            "Green","female","",""
        ))

        c.add(CarOwners(
            4,"john","doe","email","China",2002,
            "Blue","male","",""
        ))

        uiScope.launch {
            withContext(Dispatchers.IO){
                repository.insertCarOwner(c)
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}
