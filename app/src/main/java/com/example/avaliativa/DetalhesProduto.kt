package com.example.avaliativa

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

private val Nothing?.arguments: Any
    get() {
        TODO("Not yet implemented")
    }

class DetalhesProduto {


    @Composable
    fun DetalhesProdutoScreen(nomeProduto: String) {
        Text(text = "Detalhes do Produto: $nomeProduto")
        val backStackEntry = null
        val nomeProduto = backStackEntry.arguments?.getString("nomeProduto") ?: ""
        val navController = null.also {
            DetalhesProduto(nomeProduto, it)
        } // Certifique-se de chamar a função corretamente
    }
    }

private fun Any.getString(s: String): String? {

