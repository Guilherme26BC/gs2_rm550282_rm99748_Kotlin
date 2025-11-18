package guiherme26bc.com.github.gs2_rm550282_rm97748.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import guiherme26bc.com.github.gs2_rm550282_rm97748.R

@Composable
fun EquipeScreen(modifier: Modifier= Modifier, navController: NavController) {
    val integrante1 = stringResource(id = R.string.aluno1)
    val integrante2 = stringResource(id = R.string.aluno2)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE9FFE9))
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "EQUIPE",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(Modifier.height(24.dp))

            Text("Integrantes:")
            Spacer(Modifier.height(8.dp))
            Text(integrante1)
            Text(integrante2)

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.mintGreen))
            ) {
                Text("Voltar")
            }
        }
    }
}



