package pe.edu.idat.ec01_walter_vasquez

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculoScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        var resultados by rememberSaveable { mutableStateOf(listOf<Pair<Int, String>>()) }

        Column {
            Text(
                text = "CUADRADO Y MITAD DE NÚMEROS ENTRE 15 Y 70",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    resultados = calcularCuadradoYMitad()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "CALCULAR")
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(resultados) { resultado ->
                    Text(
                        text = "Número: ${resultado.first} - ${resultado.second}",
                        style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

fun calcularCuadradoYMitad(): List<Pair<Int, String>> {
    val resultados = mutableListOf<Pair<Int, String>>()
    for (i in 15..70) {
        val cuadrado = i * i
        val mitad = i / 2.0
        resultados.add(i to "Cuadrado: $cuadrado, Mitad: $mitad")
    }
    return resultados
}
