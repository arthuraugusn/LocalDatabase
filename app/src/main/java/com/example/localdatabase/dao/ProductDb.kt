package com.example.localdatabase.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.localdatabase.model.Product
import com.example.localdatabase.model.ProductDao

@Database(entities = [(Product::class)], version = 1)
abstract class ProductDb: RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object{
        private lateinit var instance: ProductDb

        fun getDatabase(context: Context): ProductDb{
            if (!::instance.isInitialized){
                instance = Room.databaseBuilder(context, ProductDb::class.java, "db_product")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance
        }
    }

}