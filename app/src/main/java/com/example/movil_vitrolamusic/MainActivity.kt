package com.example.movil_vitrolamusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.M
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movil_vitrolamusic.ui.Vitrola.VitrolaScreen
import com.example.movil_vitrolamusic.ui.theme.Movil_VitrolaMusicTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Movil_VitrolaMusicTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val navHostController = rememberNavController()

        NavHost(navController = navHostController, startDestination = "SplashScreen") {
            composable(route = "VitrolaScreen") {
                VitrolaScreen()
            }
            composable(route = "SplashScreen"){
                SplashScreen(navHostController)
            }
        }
    }
}

@Composable
fun SplashScreen( navHostController: NavHostController) {
    LaunchedEffect(key1 = true){
        delay(5000)
        navHostController.popBackStack()
        navHostController.navigate("VitrolaScreen")
    }

    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.musicicon),
            contentDescription = "Music",
            Modifier.size(150.0.dp, 150.0.dp)
        )
        Text(
            text = "Vitrola Music",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}