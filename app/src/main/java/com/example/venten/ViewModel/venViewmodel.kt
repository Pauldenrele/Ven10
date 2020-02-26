package com.example.venten.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.venten.Model.venModel
import com.example.venten.Services.RetrofitService

class AndroidViewModel: ViewModel() {

    private val mService  =  RetrofitService()

    fun getListData() : MutableLiveData<List<venModel>>? {
        Log.e("getListData","yes")
        return mService.loadlist()
    }

}
