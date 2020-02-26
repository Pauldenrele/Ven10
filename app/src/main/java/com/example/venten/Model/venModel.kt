package com.example.venten.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName ="list_table")
data class venModel(

    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "colors")
    val colors: List<Any>,

    @ColumnInfo(name = "countries")
    val countries: List<String>,

    @ColumnInfo(name = "end_year")
    @SerializedName("end_year")
    val endYear: Int,

    @ColumnInfo(name = "gender")
    val gender: String,

    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "start_year")
    @SerializedName("start_year")
    val startYear: Int
)