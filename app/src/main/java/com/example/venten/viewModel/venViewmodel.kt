package com.example.venten.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.venten.models.VenModel
import com.example.venten.data.remote.RetrofitService

class venViewModel(application: Application): AndroidViewModel(application) {
    private val mService  =  RetrofitService()

    fun getListData() : MutableLiveData<List<VenModel>>? {
        Log.e("getListData","yes")
        return mService.loadlist()

    }
}
