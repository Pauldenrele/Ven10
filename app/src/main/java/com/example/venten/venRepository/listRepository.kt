package com.example.venten.venRepository

import android.app.Application
import com.example.venten.Dao.listDao
import com.example.venten.Model.venModel
import com.example.venten.Model.venModelResp
import com.example.venten.venDatabase.venDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class listRepository(application: Application) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var listDao: listDao?

    init {
        val db = venDatabase.getDatabase(application)
        listDao = db?.venDao()
    }

    suspend fun getlist() = listDao?.getList()

    fun setList(list: List<venModelResp>) {
        launch  { setListBG(list) }
    }

    private suspend fun setListBG(list: List<venModelResp>){
        withContext(Dispatchers.IO){
            listDao?.setList(list)
        }
    }

}
