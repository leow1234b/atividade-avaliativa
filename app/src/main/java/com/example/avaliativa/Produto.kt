package com.example.avaliativa

class Produto {
    val nome: String
    val categoria: String
    val preco: String
    val quantidade: String

    data class Produto(
        val nome: String,
        val categoria: String,
        val preco: Double,
        val quantidade: Int
    )
}