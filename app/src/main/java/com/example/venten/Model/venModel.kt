package com.example.venten.Model

import com.google.gson.annotations.SerializedName

data class venModel(
    val colors: List<Any>,
    val countries: List<String>,
    @SerializedName("end_year")
    val endYear: Int,
    val gender: String,
    val id: Int,
    @SerializedName("start_year")
    val startYear: Int
)