package com.example.login.Screen

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.R

@Composable
fun Login(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    val context = LocalContext.current

    val videoUri = Uri.parse("android.resource://${context.packageName}/${R.raw.v1}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

           VideoPlayer(
                context = context,
                videoUri = videoUri,
                modifier = Modifier
                    .size(300.dp)
                    .padding(8.dp)
            )

        Spacer(modifier = Modifier.height(9.dp))

        Text(
            text = "Giriş Yap",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold

        )

        Spacer(modifier = Modifier.height(26.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.LightGray
            )
        )

        Spacer(modifier = Modifier.height(10.dp))


        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.LightGray
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Şifre") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.LightGray
            )
        )

        Spacer(modifier = Modifier.height(60.dp))


        Button(
            onClick = {

                navController.navigate("main_screen/$email/$name")
            },
            modifier = Modifier
                .size(width = 200.dp, height = 50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(text = "Giriş Yap", fontWeight = FontWeight.Bold)
        }
    }
}
