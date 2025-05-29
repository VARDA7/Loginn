package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.Screen.Favoriler
import com.example.login.Screen.Login
import com.example.login.Screen.Profile
import com.example.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginTheme {
                val navController = rememberNavController()

                // Uygulama genelinde tek bir Scaffold yerine ekranlara özel Scaffold kullanılır.
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") {
                        Login(navController)
                    }

                    composable("main_screen/{email}/{name}") { backStackEntry ->
                        val email = backStackEntry.arguments?.getString("email") ?: ""
                        val name = backStackEntry.arguments?.getString("name") ?: ""
                        MainScreen(navController,email = email, name = name)
                    }
                    composable("Profile") {
                        Profile(navController)
                    }
                    composable("Favoriler") {
                        Favoriler(navController)
                    }
                }
            }
        }
    }
}
@Composable
fun MainScreen( navController: NavController, email: String ,name: String) {
    val resim = painterResource(id = R.drawable.papatyaa)

    Scaffold(
        bottomBar = { MyBottomBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = resim,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(250.dp)
                    .border(BorderStroke(4.dp, color = Color.Black), CircleShape)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(56.dp).padding(10.dp))
            Text(text = "Hoş geldiniz, $name!", fontSize = 34.sp, modifier = Modifier.padding(20.dp))
            Spacer(modifier = Modifier.height(56.dp))
            Text(text = "Giriş yaptığınız email: $email", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun MyBottomBar(navController: NavController) {
    BottomAppBar(
        containerColor = Color.White,
        contentColor = Color.Black,
        tonalElevation = 8.dp,
        actions = {
            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = {  navController.navigate("Favoriler")}) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favoriler",modifier = Modifier.size(32.dp))
            }
            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = { navController.navigate("main_screen/{email}/{name}")}) {
                Icon(Icons.Filled.Home, contentDescription = "Ana Sayfa", modifier = Modifier.size(32.dp))
            }
            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = { navController.navigate("Profile") }) {
                Icon(Icons.Filled.AccountCircle, contentDescription = "Profil",modifier = Modifier.size(32.dp))
            }
            Spacer(modifier = Modifier.weight(1f))

        }
    )
}
