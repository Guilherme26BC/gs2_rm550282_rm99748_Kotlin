package guiherme26bc.com.github.gs2_rm550282_rm97748

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import guiherme26bc.com.github.gs2_rm550282_rm97748.screens.EquipeScreen
import guiherme26bc.com.github.gs2_rm550282_rm97748.screens.ImcScreen
import guiherme26bc.com.github.gs2_rm550282_rm97748.screens.MenuScreen
import guiherme26bc.com.github.gs2_rm550282_rm97748.ui.theme.Gs2_rm550282_rm97748Theme
import guiherme26bc.com.github.gs2_rm550282_rm97748.screens.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Gs2_rm550282_rm97748Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route ="login"){
                            LoginScreen(modifier = Modifier.padding(innerPadding),navController= navController )
                        }
                        composable(route= "menu"){
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController = navController)
                        }
                        composable(route = "calculoImc"){
                            ImcScreen(modifier= Modifier.padding(innerPadding), navController = navController)
                        }
                        composable(route = "Equipe"){
                            EquipeScreen(modifier = Modifier.padding(innerPadding), navController = navController)
                        }
                    }
                }
            }
        }
    }
}
