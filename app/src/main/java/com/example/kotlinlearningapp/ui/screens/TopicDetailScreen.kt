package com.example.kotlinlearningapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlinlearningapp.viewmodel.TopicViewModel
import com.example.kotlinlearningapp.ui.components.AppToolbar
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun TopicDetailScreen(
    topicId: Int,
    navController: NavController,
    viewModel: TopicViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Topic Detail",
                canNavigateBack = true,
                navController = navController
            )
        }
    ) { padding ->
        val topic = viewModel.getTopicById(topicId)

        topic?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = it.title,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(" Theory", style = MaterialTheme.typography.titleLarge)
                Text(it.theory)

                Spacer (modifier = Modifier.height(20.dp))
                Text(" Code", style = MaterialTheme.typography.titleLarge)

                Card {
                    Text(
                        text = it.code,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("quiz/$topicId")
                    },
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    Text("Go to Quiz")
                }
            }
        }

        if (topic == null) {
            Text(
                text = "Theme not found",
                modifier = Modifier.padding(padding)
            )
            return@Scaffold
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicDetailScreenPreview() {
    MaterialTheme {
        val navController = rememberNavController()
        TopicDetailScreen(
            topicId = 1,
            navController = navController
        )
    }
}