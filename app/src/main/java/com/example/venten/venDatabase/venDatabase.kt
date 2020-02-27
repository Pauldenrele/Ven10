package com.example.venten.venDatabase

import android.content.Context
import androidx.room.*
import com.example.venten.Dao.listDao
import com.example.venten.Model.venModel
import com.example.venten.Model.venModelResp

@Database(entities = [venModelResp::class], version = 1, exportSchema = false)
abstract class venDatabase:RoomDatabase() {

    abstract fun venDao():listDao

    companion object {

        @Volatile
        private var INSTANCE: venDatabase? = null

        fun getDatabase(context: Context): venDatabase? {
            if (INSTANCE == null) {
                synchronized(venDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            venDatabase::class.java, "list_cars_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}