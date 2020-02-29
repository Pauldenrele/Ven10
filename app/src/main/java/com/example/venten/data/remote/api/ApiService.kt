package com.example.venten.data.remote.api

import com.example.venten.models.VenModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/assessment/filter.json")
    fun getlist(): Call<List<VenModel>>
}