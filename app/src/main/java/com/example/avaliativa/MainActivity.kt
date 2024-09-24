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
     data  class Produto(val nome: String,val categoria: String,val preco: Double, val quantidade: Int)
     
     class Estoque {
        companion object {
             val produtos = mutableListOf<Produto>()

            fun adicionarProduto(produto: Produto) {
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
    
    private fun rememberNavController(): Any {

        return TODO("Provide the return value")
    }

    private fun viewModel(): ProdutoViewModel {
        TODO("Not yet implemented")
    }



@Composable
fun DetalhesProduto(nomeProduto: String, navController: NavController) {
    // Aqui você pode buscar as informações do produto baseado no nome
    // Para simplicidade, estamos usando dados fictícios
    
    val produto = Gson().fromJson(novoProduto, MainActivity.Produto::class.java)
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
fun ProdutoViewModel() {
    val navController = rememberNavController()
    NavHost1(navController, startDestination = "cadastrar") {
         composable("cadastrar") {
           
        } 
    composable("estatisticas"){
        estatistica(navController)
    }
        
        composable("listaProdutos") {
            ListaProdutosScreen( navController)
        }
        composable("detalhes/{nomeProduto}") { backStackEntry ->
            val nomeProduto = (backStackEntry.arguments?.getString("nomeProduto") ?: "").also {
                DetalhesProduto1(nomeProduto , navController = navController)
            }
        }
    }
}

@Composable
fun ListaProdutosScreen( NavController) {
    Column {
        LazyColumn{
            items(Estoque.produtos.size){
                index->
                val produto = Estoque.produtos[index]
                Row {
                    Text("${produto.nome} (${produto.quantidade}unidades)")
                    Button(onClick = {
                        val produto = Gson().toJson(produto)
                        navController.navigate("detalhes/$produto")
                        
                    }) {
                        Text("detalhes")
                    }
                }
            }
           
       
        }
         Button(onClick = {
                navController.navigate("estatisticas")
            }) {
                Text("estatisticas")
            }
    }
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
 @composable
 fun cadastro(navController:NavController){
   
    val nome by remember{mutableStateOf("")}
 
     val categoria by remember{mutableStateOf("")}

      val quantide by remember{mutableStateOf("")}
      
       val preco by remember{mutableStateOf("")}

 

 TextField(value = preco,onValueChange = {preco = it},label = {Text = "preco"})


TextField(value = categoria,onValueChange = {categoria = it},label = {Text = "categoria"})


TextField(value = quantidade,onValueChange = {quantidade = it},label = {Text = "quantidade"})


TextField(value = nome,onValueChange = {nome = it},label = {Text = "nome"})

Button(onClick ={
    val produto = MainActivity.produto(nome,categoria,preco.toDouble,quantidade.toInt)
     Estoque.adicionarProduto(produto)
   navController.navigate("listaProdutos")

   
}){Text({cadastrar})}



 }

@composable
fun estatistica(navController:NavController){
    val Valor = MainActivity.Estoque.calcularValorTotalEstoque()

    val quantidade =MainActivity.Estoque.produtos.sumOf{it.quantidade
    Column {Text("valor total do estoque ${valor}")}
            Text("quantidade total do estoque ${quantidade}")


    }

}



produtos








 