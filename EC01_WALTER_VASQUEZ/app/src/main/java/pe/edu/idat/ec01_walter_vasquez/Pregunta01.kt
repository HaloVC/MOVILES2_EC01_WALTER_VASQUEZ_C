/*package pe.edu.idat.ec01_walter_vasquez

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PromedioScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)){

        var ec1 by rememberSaveable {
            mutableStateOf("")
        }
        var ec2 by rememberSaveable {
            mutableStateOf("")
        }
        var ec3 by rememberSaveable {
            mutableStateOf("")
        }
        var ef by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "PROMEDIO DE NOTAS IDAT",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace(16)
            OutlinedTextField(value = ec1,
                onValueChange = { ec1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text ="Ingrese EC 1")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(value = ec2,
                onValueChange = { ec2 = it },
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text ="Ingrese EC 2")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(value = ec3,
                onValueChange = { ec3 = it },
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text ="Ingrese EC 3")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(value = ef,
                onValueChange = { ef = it },
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text ="Ingrese EF")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            Button(onClick = {
                resultado = calcularPromedio(ec1.toInt(),
                    ec2.toInt(), ec3.toInt(), ef.toInt())
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            MySpace(espacio = 16)
            Text(text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray))
        }
    }
}



fun calcularPromedio(ec1: Int, ec2: Int, ec3: Int, ef:Int): String{
    var promedio = (ec1 * 0.04) + (ec2 * 0.12) + (ec3 * 0.24) + (ef * 0.6)
    var resultado = "DESAPROBADO"
    if(promedio > 12.5){
        resultado = "APROBADO"
    }
    return "Su promedio es $promedio su estado es $resultado"
}*/

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