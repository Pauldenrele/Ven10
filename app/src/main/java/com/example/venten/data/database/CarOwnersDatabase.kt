package com.example.venten.data.database

import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.venten.models.CarOwners
import com.opencsv.CSVReader
import kotlinx.coroutines.CoroutineScope
import java.io.File
import java.io.FileReader
import java.util.concurrent.Executors


@Database(entities = [CarOwners::class], version = 1, exportSchema = false)
abstract class CarOwnersDatabase : RoomDatabase() {
    abstract fun carOwnersDao(): CarOwnersDao

    companion object {
        private var INSTANCE: CarOwnersDatabase? = null
        @Synchronized
        fun getInstance(
            context: Context
            , scope: CoroutineScope
        ): CarOwnersDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarOwnersDatabase::class.java,
                    "car_owners_database"
                ).addCallback(CarOwnersCallBack(scope)).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }

        private class CarOwnersCallBack(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->

                    populateDatabase(database.carOwnersDao())

                }
            }
        }

        fun populateDatabase(carOwnersDao: CarOwnersDao) {

            Executors.newSingleThreadScheduledExecutor()
                .execute(Runnable {
                    var row: Array<String>? = null

                    val csvfile =
                        File(Environment.getExternalStorageDirectory().toString() + "car_ownsers_data.csv")

                    val csvReader = CSVReader(FileReader(csvfile))
                    val content = csvReader.readAll()

                    for (`object` in content) {
                        row = `object` as Array<String>


                        Log.d(
                            "Datarr",
                            row[0] + row[1] + "#" + row[2] + "#" + row[3] + "#" + row[4] + "#" + row[5] + "#" + row[6] + "#" + row[7] + "#" + row[8] + "#" + row[9] + "#" + row[10]
                        )


                    }

                    csvReader.close()


                })


        }

    }
}

