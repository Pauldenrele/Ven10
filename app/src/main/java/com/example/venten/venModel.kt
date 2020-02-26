package com.example.venten

import com.google.gson.annotations.SerializedName

data class venModel(
    val colors: List<Any>,
    val countries: List<String>,
    @SerializedName("end_year")
    val endYear: Int, // 2009
    val gender: String,
    val id: Int, // 5
    @SerializedName("start_year")
    val startYear: Int // 1990
)