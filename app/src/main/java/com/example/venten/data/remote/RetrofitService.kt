package com.example.venten.data.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.venten.models.VenModel
import com.example.venten.data.remote.api.ApiService
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    val liveListResponse: MutableLiveData<List<VenModel>> = MutableLiveData()

    companion object Factory {
        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiService {
            Log.e("retrofit","create")

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://ven10.co/")
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    fun loadlist(): MutableLiveData<List<VenModel>>? {

        Log.e("loadlist","yes")

        val retrofitCall  = create()
            .getlist()

        retrofitCall.enqueue(object : Callback<List<VenModel>> {
            override fun onFailure(call: Call<List<VenModel>>, t: Throwable?) {
                Log.e("on Failure :", "retrofit error")
            }

            override fun onResponse(call: Call<List<VenModel>>, response: retrofit2.Response<List<VenModel>>) {

                val list  = response.body()
                for (i in list.orEmpty()){
                    Log.e("on response 1:", i.endYear.toString())
                }


                liveListResponse.value = list



                Log.e("hasActiveObservers 1", liveListResponse.hasActiveObservers().toString()+" check")

                Log.e("on response 2 :", liveListResponse.toString()+" check")

            }

        })

        return liveListResponse
    }
}
