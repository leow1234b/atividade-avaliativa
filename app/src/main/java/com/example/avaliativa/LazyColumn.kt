package com.example.avaliativa


    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items

    import androidx.compose.material3.Button
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.unit.dp
    import androidx.navigation.NavController


class LazyColumn {
    @Composable
    fun ListaProdutosScreen(viewModel: ProdutoViewModel, navController: NavController) {
        LazyColumn {
            items(viewModel.produtos) { produto ->
                ProdutoItem(produto) {
                    navController.navigate("detalhes/${produto.nome}")
                }
            }
        }
    }

    @Composable
    fun ProdutoItem(produto: Produto, onClick: () -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(16.dp)
        ) {
            Text(text = "${produto.nome} (${produto.quantidade} unidades)")
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = onClick) {
                Text("Detalhes")
            }
        }
    }

}