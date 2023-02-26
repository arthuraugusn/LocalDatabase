package com.example.localdatabase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_produto")
data class Product(
    @PrimaryKey(true) var id: Long = 0,
    @ColumnInfo( "name") var productName: String = "Product's name",
    @ColumnInfo("price") var productPrice: Double = 0.0,
    @ColumnInfo("description") var productDescription: String = "Product's description"
)
