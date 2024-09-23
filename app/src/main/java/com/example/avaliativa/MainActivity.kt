package com.example.avaliativa



import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.coroutines.jvm.internal.CompletedContinuation.context
import androidx.navigation.NavHost as NavHost1
import com.example.avaliativa.DetalhesProduto as DetalhesProduto1
import com.example.avaliativa.navigate as navigate1


private val Nothing?.nome: String
    get() {
        TODO("Not yet implemented")
    }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Configura o controlador de navegação e a ViewModel
            val navController = rememberNavController()
            val produtoViewModel: ProdutoViewModel = viewModel()
            ProdutoViewModel(navController, produtoViewModel) // Chama sua função de navegação
        }
    }

    private fun rememberNavController(): Any {

        return TODO("Provide the return value")
    }

    private fun viewModel(): ProdutoViewModel {
        TODO("Not yet implemented")
    }
}


@Composable
fun DetalhesProduto(nomeProduto: String, navController: NavHostController) {
    // Aqui você pode buscar as informações do produto baseado no nome
    // Para simplicidade, estamos usando dados fictícios
    val produto = remember { Produto(nomeProduto, "Categoria A", 100.0, 10) } // Substitua pela sua lógica de obtenção de dados

    // Exibe as informações do produto
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Nome: ${produto.nome}")
        Text(text = "Categoria: ${produto.categoria}")
        Text(text = "Preço: R$ ${produto.preco}")
        Text(text = "Quantidade: ${produto.quantidade} unidades")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Voltar")
        }
    }
}

fun Produto(nomeProduto: String, s: String, d: Double, i: Int): Produto {

    return TODO("Provide the return value")
}

@Composable
fun ProdutoViewModel(navController: NavHostController, produtoViewModel: ProdutoViewModel) {
    NavHost1(navController, startDestination = "listaProdutos") {
        composable("listaProdutos") {
            ListaProdutosScreen(produtoViewModel = produtoViewModel, navController = navController)
        }
        composable("detalhes/{nomeProduto}") { backStackEntry ->
            val nomeProduto = (backStackEntry.arguments?.getString("nomeProduto") ?: "").also {
                DetalhesProduto1(nomeProduto = it, navController = navController)
            }
        }
    }
}

@Composable
fun ListaProdutosScreen(produtoViewModel: ProdutoViewModel, navController: NavHostController) {
    TODO("Not yet implemented")
}

fun composable(s: String, any: Any) {
    TODO("Not yet implemented")
}

Button(onClick =
private fun Nothing?.navigate(s: String) {
    TODO("Not yet implemented")
}

{
    val navController = null.also {
        val produto: Nothing? = null
        it.navigate1(s = context.getString(
            R.string.detalhes,
            produto.nome
        ))
    }
}) {
    Text(text = "Detaches")
}

fun cadastrarProduto(nome: String, categoria: String, preco: Double, quantidade: Int, context: Context) {
    val novoProduto = Produto(nome, categoria, preco, quantidade)
    Estoque.adicionarProduto(novoProduto, context)
}

