package com.example.kotlinlearningapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinlearningapp.viewmodel.TopicViewModel
import com.example.kotlinlearningapp.ui.components.AppToolbar
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun TopicListScreen(
    level: String,
    navController: NavController,
    viewModel: TopicViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Topics: \$level",
                canNavigateBack = true,
                navController = navController
            )
        }
    ) { padding ->
        val topics = viewModel.getTopics(level)
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)) {
            Text(
                text = "Level: \$level",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn {
                items(topics) { topic ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                navController.navigate("detail/\${topic.id}")
                            }
                    ) {
                        Text(
                            text = topic.title,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicListScreenPreview() {
    MaterialTheme {
        val navController = rememberNavController()
        TopicListScreen(
            level = "Beginner",
            navController = navController
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopicListScreenPreviewIntermediate() {
    MaterialTheme {
        val navController = rememberNavController()
        TopicListScreen(
            level = "Intermediate",
            navController = navController
        )
    }
}