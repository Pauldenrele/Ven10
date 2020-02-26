package com.example.venten.interfaces

import com.example.venten.Model.venModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/assessment/filter.json")
    fun getlist(): Call<List<venModel>>
}