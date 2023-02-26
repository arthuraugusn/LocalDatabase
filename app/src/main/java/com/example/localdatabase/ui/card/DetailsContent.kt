package com.example.localdatabase.ui.card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.localdatabase.model.Product

@Composable
fun DetailsContent(list: List<Product>) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
        items(list){ ProductCard(produto = it) }
    }
}