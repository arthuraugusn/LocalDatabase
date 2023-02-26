package com.example.localdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.localdatabase.model.Product
import com.example.localdatabase.model.repository.ProductRepository
import com.example.localdatabase.ui.card.DetailsContent
import com.example.localdatabase.ui.theme.LocalDatabaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocalDatabaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    val repository: ProductRepository = ProductRepository(LocalContext.current)

    var productsList by remember {
        mutableStateOf(listOf<Product>())
    }

    productsList = repository.getProductList()

    var nameState by remember {
        mutableStateOf("")
    }

    var priceState by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        OutlinedTextField(value = nameState, onValueChange = { nameState = it }, label = {Text("Name")}, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = priceState, onValueChange = { priceState = it }, label = {Text("Price")}, modifier = Modifier.fillMaxWidth())

        Button(onClick = {
            repository.insertProduct(Product(productName = nameState, productPrice = priceState.toDouble()))
            productsList = repository.getProductList()
        }, modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Cadastrar")
        }

        DetailsContent(productsList)
    }

}
