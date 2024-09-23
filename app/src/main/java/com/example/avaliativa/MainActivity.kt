@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.avaliativa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.avaliativa.ui.theme.AvaliativaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvaliativaTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ProductRegistrationScreen()
                }
            }
        }
    }
}

@Composable
fun ProductRegistrationScreen() {
    var productName by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var stockQuantity by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    val productList = remember { mutableStateListOf<Product>() }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Cadastro de Produto", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text("Nome do Produto") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Categoria") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Preço") },
            modifier = Modifier.fillMaxWidth(),
            isError = price.toDoubleOrNull() == null && price.isNotEmpty()
        )
        TextField(
            value = stockQuantity,
            onValueChange = { stockQuantity = it },
            label = { Text("Quantidade em Estoque") },
            modifier = Modifier.fillMaxWidth(),
            isError = stockQuantity.toIntOrNull() == null && stockQuantity.isNotEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (productName.isNotEmpty() && category.isNotEmpty() && price.toDoubleOrNull() != null && stockQuantity.toIntOrNull() != null) {
                val newProduct = Product(productName, category, price.toDouble(), stockQuantity.toInt())
                productList.add(newProduct)
                message = "Produto cadastrado com sucesso!"
                productName = ""
                category = ""
                price = ""
                stockQuantity = ""
            } else {
                message = "Por favor, preencha todos os campos corretamente!"
            }
        }) {
            Text(text = "Cadastrar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (message.isNotEmpty()) {
            Text(text = message, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

data class Product(val name: String, val category: String, val price: Double, val quantity: Int)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AvaliativaTheme {
        ProductRegistrationScreen()
    }
}
