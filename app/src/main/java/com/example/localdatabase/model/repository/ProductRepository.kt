package com.example.localdatabase.model.repository

import android.content.Context
import com.example.localdatabase.dao.ProductDb
import com.example.localdatabase.model.Product

class ProductRepository(context: Context) {

    private val db = ProductDb.getDatabase(context).productDao()

    fun getProductList(): List<Product>{
        return db.getAllProdutos()
    }

    fun insertProduct(product: Product): Long{
        return db.save(product)
    }

}