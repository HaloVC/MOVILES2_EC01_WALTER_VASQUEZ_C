package pe.edu.idat.ec01_walter_vasquez

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun MenuScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ) {
        Column {
            Text(
                text = "SELECCIONE OPCIONES",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace(16)
            Button(
                onClick = {
                    navController.navigate("jubilacion")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00CC99),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp) // Padding horizontal para el botón
            ) {
                Text(text = "CALCULAR JUBILACION",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
            MySpace(16)
            Button(
                onClick = {
                    navController.navigate("numero_menor")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00CC99	),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp) // Padding horizontal para el botón
            ) {
                Text(text = "CALCULAR EL MENOR NUMERO",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
            MySpace(16)
            Button(
                onClick = {
                    navController.navigate("matricula")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00CC99),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp) // Padding horizontal para el botón
            ) {
                Text(text = "MATRICULA DE ALUMNOS")
            }
            MySpace(16)
            Button(
                onClick = {
                    navController.navigate("")

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF299116),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp) // Padding horizontal para el botón
            ) {
                Text(text = "CALCULAR")
            }
        }
    }
}