package com.example.venten

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.opencsv.CSVParser

import com.opencsv.CSVReader
import java.nio.file.Files
import java.nio.file.Paths
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast
import java.io.FileReader

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.io.File


class CsvActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_csv)

var row:Array<String>? = null
val csvFilename = "C:\\work\\sample.csv"

        val csvfile = File(Environment.getExternalStorageDirectory().toString() + "/Internal storage/Download/car_ownsers_data(1).csv")

        val csvReader = CSVReader(FileReader(csvfile))
val content = csvReader.readAll()

for (`object` in content)
{
row = `object` as Array<String>

Toast.makeText(this ,
    row!![0]
    + " # " + row!![1]
    + " #  " + row!![2]
,Toast.LENGTH_LONG
).show()
}
//...
csvReader.close()

    }

}
