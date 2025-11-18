package guiherme26bc.com.github.gs2_rm550282_rm97748.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import guiherme26bc.com.github.gs2_rm550282_rm97748.R


@Composable
fun ImcScreen(modifier: Modifier= Modifier, navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var weightText by remember { mutableStateOf("") }
    var heightText by remember { mutableStateOf("") }

    val imc = remember { mutableStateOf(0.0) }
    val statusImc = remember { mutableStateOf("") }

    var error by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE9FFE9))
            .padding(24.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Calculadora IMC",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(Modifier.height(24.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Seu nome") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = weightText,
                onValueChange = { weightText = it },
                label = { Text("Seu peso (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = heightText,
                onValueChange = { heightText = it },
                label = { Text("Sua altura (m)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    val weight = weightText.replace(",", ".").toDoubleOrNull()
                    val height = heightText.replace(",", ".").toDoubleOrNull()

                    if (weight == null || height == null || height == 0.0) {
                        error = "Preencha peso e altura válidos"
                        statusImc.value = ""
                        imc.value = 0.0
                    } else {
                        val result = weight / (height * height)
                        imc.value = result
                        error = null

                        statusImc.value = when {
                            result < 18.5 -> "Abaixo do peso"
                            result < 24.9 -> "Peso normal"
                            result < 29.9 -> "Sobrepeso"
                            result < 34.9 -> "Obesidade Grau I"
                            result < 39.9 -> "Obesidade Grau II"
                            else -> "Obesidade Grau III"
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.mintGreen))
            ) {
                Text("Calcular")
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.mintGreen))
            ) {
                Text("Voltar")
            }

            Spacer(Modifier.height(16.dp))

            error?.let {
                Text(text = it, color = MaterialTheme.colorScheme.error)
            }

            if (statusImc.value.isNotEmpty()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(horizontal = 32.dp, vertical = 24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xff329F6B)),
                    elevation = CardDefaults.cardElevation(4.dp),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 32.dp)
                            .fillMaxSize()
                    ) {
                        Column {
                            Text(
                                text = "Resultado",
                                color = Color.White,
                                fontSize = 14.sp
                            )

                            Text(
                                text = name,
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Text(
                                text = statusImc.value,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 20.sp
                            )
                        }

                        Text(
                            text = String.format("%.1f", imc.value),
                            modifier = Modifier.fillMaxWidth(),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 36.sp,
                            textAlign = TextAlign.End
                        )
                    }
                }
            }


        }
    }
}
