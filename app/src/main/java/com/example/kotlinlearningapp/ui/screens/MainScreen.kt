package com.example.kotlinlearningapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinlearningapp.ui.components.AppToolbar
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen (navController: NavController) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Kotlin Learning",
                canNavigateBack = false,
                navController = navController
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Kotlin Learning App",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer (modifier = Modifier.height(20.dp))
            Button(onClick = {
                navController.navigate("beginner")
            }) {
                Text("Basic Level")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                navController.navigate("intermediate")
            }) {
                Text("Intermediate Level")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController = navController)
}