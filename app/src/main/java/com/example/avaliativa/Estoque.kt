package com.example.avaliativa



    import android.content.Context
    import android.widget.Toast
    class Estoque {
    class Estoque {
        companion object {
            private val produtos = mutableListOf<Produto>()

            fun adicionarProduto(produto: Produto, context: Context) {
                if (produto.quantidade < 1) {
                    Toast.makeText(context, "Quantidade deve ser maior ou igual a 1", Toast.LENGTH_SHORT).show()
                    return
                }
                if (produto.preco < 0) {
                    Toast.makeText(context, "Preço não pode ser menor que 0", Toast.LENGTH_SHORT).show()
                    return
                }

                produtos.add(produto)
            }

            fun calcularValorTotalEstoque(): Double {
                return produtos.sumOf { it.preco * it.quantidade }
            }

            fun listarProdutos(): List<Produto> {
                return produtos
            }
        }
    }

        companion object {
            fun adicionarProduto(novoProduto: Produto, context: Any) {

            }

            fun listarProdutos(): List<Produto> {
                TODO("Not yet implemented")
            }
        }

    }

Button(onClick = {
    val nome = ("").also {
        val categoria = ""
        cadastrarProduto(it, categoria, preco, quantidade, context)
    }
}) {
    Text(text = "Cadastrar Produto")
}


val produtoViewModel: Any
    get() {
        TODO()
    }
val valorTotal = produtoViewModel.calcularValorTotalEstoque()

private fun Any.calcularValorTotalEstoque(): Any {
    TODO("Not yet implemented")
}
Text(text = "Valor Total do Estoque: R$ $valorTotal")

val valorTotal = produtoViewModel.calcularValorTotalEstoque()
Text(text = "Valor Total do Estoque: R$ $valorTotal")
