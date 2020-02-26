package com.example.venten.Services

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.venten.Model.venModel
import com.example.venten.interfaces.ApiInterface
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    val liveListResponse: MutableLiveData<List<venModel>> = MutableLiveData()

    companion object Factory {
        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiInterface {
            Log.e("retrofit","create")

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://ven10.co/")
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }

    fun loadlist(): MutableLiveData<List<venModel>>? {

        Log.e("loadlist","yes")

        val retrofitCall  = create().getlist()

        retrofitCall.enqueue(object : Callback<List<venModel>> {
            override fun onFailure(call: Call<List<venModel>>, t: Throwable?) {
                Log.e("on Failure :", "retrofit error")
            }

            override fun onResponse(call: Call<List<venModel>>, response: retrofit2.Response<List<venModel>>) {

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
