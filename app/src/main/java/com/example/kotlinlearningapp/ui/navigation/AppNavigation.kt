package com.example.kotlinlearningapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.kotlinlearningapp.ui.screens.MainScreen
import com.example.kotlinlearningapp.ui.screens.TopicListScreen
import com.example.kotlinlearningapp.ui.screens.TopicDetailScreen
import com.example.kotlinlearningapp.ui.screens.QuizScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController)
        }
        composable("beginner") {
            TopicListScreen(
                level = "Beginner",
                navController = navController
            )
        }
        composable("intermediate") {
            TopicListScreen(
                level = "Intermediate",
                navController = navController
            )
        }
        composable("detail/{topicId}") { backStackEntry ->
            val topicId = backStackEntry.arguments?.getString("topicId")?.toInt() ?: 0
            TopicDetailScreen(topicId, navController)
        }
        composable("quiz/{topicId}") { backStackEntry ->
            val topicId = backStackEntry.arguments
                ?.getString("topicId")
                ?.toInt() ?: 0
            QuizScreen(topicId, navController)
        }
    }
}