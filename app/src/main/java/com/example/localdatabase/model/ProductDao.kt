package com.example.localdatabase.model

import androidx.room.*

@Dao
interface ProductDao {

    @Insert
    fun save(product: Product): Long

    @Query("SELECT * FROM tbl_produto ORDER BY name ASC")
    fun getAllProdutos():List<Product>

    @Update
    fun update(product: Product): Int

    @Delete
    fun delete(product: Product): Int


}