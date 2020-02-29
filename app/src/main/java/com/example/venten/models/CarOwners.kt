package com.example.venten.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car_owners")
data class CarOwners(

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,

    @ColumnInfo(name = "first_name")
    var firstName : String,

    @ColumnInfo(name = "last_name")
    var lastName : String,

    @ColumnInfo(name = "email")
    var email : String,

    @ColumnInfo(name = "country")
    var country : String,

    @ColumnInfo(name = "car_model")
    var carModel : Int,

    @ColumnInfo(name = "car_color")
    var carColor : String,

    @ColumnInfo(name = "gender")
    var gender : String,

    @ColumnInfo(name = "job_title")
    var jobTitle : String,

    @ColumnInfo(name = "bio")
    var bio : String

)
