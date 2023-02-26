package com.example.localdatabase.ui.card

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.localdatabase.model.Product

@Composable
fun ProductCard (produto: Product){

    Card(
        modifier = Modifier .fillMaxWidth() .height(80.dp) .padding(horizontal = 8.dp, vertical = 8.dp),
        elevation = 2.dp,
        backgroundColor = Color(0xFFC392FF),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = produto.productName, color = Color.White)
                Text(text = produto.productDescription, color = Color.White)
            }
            Text(text = "R$ ${produto.productPrice}", color = Color.White)
        }
    }
}
