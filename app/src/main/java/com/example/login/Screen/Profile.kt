package com.example.login.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.MyBottomBar
import com.example.login.R

@Composable
fun Profile(navController: NavController) {
    Scaffold(
        bottomBar = { MyBottomBar(navController) }
    ) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding).fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.user), contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(220.dp).clip(CircleShape).border(2.dp, Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Abdullah VARDAL", style = MaterialTheme.typography.titleLarge, fontSize = 34.sp)

            Spacer(modifier = Modifier.height(42.dp))

            Text(text = "abdullah_vardal23@erdogan.edu.tr", style = MaterialTheme.typography.bodyMedium, color = Color.Gray, fontSize = 14.sp)
        }


    }
}
