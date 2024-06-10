package pe.edu.idat.ec01_walter_vasquez


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MatriculaScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {

        var numeroMaterias by rememberSaveable { mutableStateOf("") }
        var resultado by rememberSaveable { mutableStateOf("") }

        Column {
            Text(
                text = "CALCULAR COSTO DE MATRÍCULA",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = numeroMaterias,
                onValueChange = { numeroMaterias = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el número de materias") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    resultado = calcularCostoMatricula(numeroMaterias.toInt())
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "CALCULAR")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

fun calcularCostoMatricula(numeroMaterias: Int): String {
    val costoMateria = 520
    val totalCosto = costoMateria * numeroMaterias
    val costoFinal = if (numeroMaterias > 5) totalCosto * 0.9 else totalCosto
    return "El costo total de la matrícula es S/ $costoFinal"
}
