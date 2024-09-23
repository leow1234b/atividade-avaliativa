package com.example.avaliativa


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ProdutoViewModel(navController: Any, produtoViewModel: ProdutoViewModel) : ViewModel() {
    // Lista mutável de produtos
    private val _produtos = mutableStateListOf<Produto>()
    val produtos: List<Produto> get() = _produtos

    // Função para adicionar um produto à lista
    fun adicionarProduto(produto: Produto) {
        _produtos.add(produto)
    }
}



fun listarProdutos(): List<Produto> {
    return Estoque.listarProdutos()
}

fun calcularValorTotalEstoque(): Double {
    return Estoque.calcularValorTotalEstoque()
}
}
