package com.example.venten.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.venten.Model.venModel
import com.example.venten.Model.venModelResp
import com.example.venten.Services.RetrofitService
import com.example.venten.venRepository.listRepository

class venViewModel(application: Application): AndroidViewModel(application) {

    private val mService  =  RetrofitService()

    private var repository: listRepository =listRepository(application)

    suspend fun getList() :MutableLiveData<List<venModel>>?{
        repository.getlist()

        return mService.loadlist()

    }
    fun setMessage(list: List<venModelResp>) { repository.setList(list)}

    fun getListData() : MutableLiveData<List<venModel>>? {
        Log.e("getListData","yes")
        return mService.loadlist()

    }

}
