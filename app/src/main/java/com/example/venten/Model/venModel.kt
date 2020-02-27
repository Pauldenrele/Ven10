package com.example.venten.Model

import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull
import org.json.JSONObject

open class venModel{
    @SerializedName("colors")
    @Expose
    val colors: List<Any>?= null
    @SerializedName("countries")
    @Expose
    val countries: List<String>?= null

    @SerializedName("end_year")
    @Expose
    val endYear: Int?= null

    @SerializedName("gender")
    @Expose
    val gender: String = ""

    @SerializedName("id")
    @Expose
    val id: Int?= null

    @SerializedName("start_year")
    val startYear: Int?=null
}
@Entity(tableName ="list_table")
data class venModelResp(

    @PrimaryKey(autoGenerate = true)
@NonNull
    @Expose
    val countries: Long ,

    @Expose
    val colors: String
        ,

    @SerializedName("end_year")
    @Expose
    val endYear: Int,


@Expose
    val gender: String,

    val id: Int,

    @SerializedName("start_year")
    val startYear: Int
){
    companion object {
        const val TABLE_NAME = "list_table"
    }

}


/*
open class Countries {
    @SerializedName("countries")
    @Expose
    var countries: String? = ""

    fun toJSON(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("countries", countries)
        return jsonObject
    }


    }

class CountryConverter{
    @TypeConverter
    fun countryToString(country: Countries?): String? {
        return (if (country == null) null else {
            country.toJSON().toString()
        })
    }



}*/
