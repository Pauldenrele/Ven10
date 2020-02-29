package com.example.venten.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class VenModel(
    @SerializedName("colors")
    @Expose
    val colors: List<String>? = null,

    @SerializedName("countries")
    @Expose
    val countries: List<String>? = null,

    @SerializedName("end_year")
    @Expose
    val endYear: Int? = null,

    @SerializedName("gender")
    @Expose
    val gender: String = "",

    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("start_year")
    val startYear: Int? = null

) : Parcelable






