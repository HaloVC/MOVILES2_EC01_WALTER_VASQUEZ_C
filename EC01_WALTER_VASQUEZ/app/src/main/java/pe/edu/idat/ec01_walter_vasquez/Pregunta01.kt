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
fun JubilacionScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp)) {

        var edad by rememberSaveable { mutableStateOf("") }
        var sexo by rememberSaveable { mutableStateOf("Hombre") }
        var resultado by rememberSaveable { mutableStateOf("") }

        Column {
            Text(
                text = "CALCULAR JUBILACIÓN",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = edad,
                onValueChange = { edad = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese Edad") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Seleccione Sexo")
            Row {
                RadioButton(
                    selected = sexo == "Hombre",
                    onClick = { sexo = "Hombre" },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)
                )
                Text(text = "Hombre")
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = sexo == "Mujer",
                    onClick = { sexo = "Mujer" },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Green)
                )
                Text(text = "Mujer")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    resultado = puedeJubilarse(edad.toInt(), sexo)
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

fun puedeJubilarse(edad: Int, sexo: String): String {
    val puedeJubilarse = (sexo == "Hombre" && edad >= 60) || (sexo == "Mujer" && edad > 54)
    return if (puedeJubilarse) "Usted puede jubilarse." else "Usted no puede jubilarse."
}

@Composable
fun SpacerHeight(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

@Composable
fun SpacerWidth(width: Int) {
    Spacer(modifier = Modifier.width(width.dp))
}