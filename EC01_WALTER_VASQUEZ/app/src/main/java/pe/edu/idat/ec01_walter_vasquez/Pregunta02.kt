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
fun CalcularMenorScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {

        var numero1 by rememberSaveable { mutableStateOf("") }
        var numero2 by rememberSaveable { mutableStateOf("") }
        var numero3 by rememberSaveable { mutableStateOf("") }
        var numero4 by rememberSaveable { mutableStateOf("") }
        var resultado by rememberSaveable { mutableStateOf("") }

        Column {
            Text(
                text = "CALCULAR EL NÚMERO MENOR",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = numero1,
                onValueChange = { numero1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el número 1") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = numero2,
                onValueChange = { numero2 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el número 2") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = numero3,
                onValueChange = { numero3 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el número 3") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = numero4,
                onValueChange = { numero4 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el número 4") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    resultado = calcularMenor(
                        numero1.toInt(),
                        numero2.toInt(),
                        numero3.toInt(),
                        numero4.toInt()
                    )
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

fun calcularMenor(num1: Int, num2: Int, num3: Int, num4: Int): String {
    val menor = minOf(num1, num2, num3, num4)
    return "El número menor es $menor"
}
