package com.example.kotlinlearningapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlinlearningapp.viewmodel.TopicViewModel
import com.example.kotlinlearningapp.ui.components.AppToolbar
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun QuizScreen(
    topicId: Int,
    navController: NavController,
    viewModel: TopicViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Quiz",
                canNavigateBack = true,
                navController = navController
            )
        }
    ) { padding ->
        val topic = viewModel.getTopicById(topicId)

        var currentQuestionIndex by remember { mutableIntStateOf(0) }
        var score by remember { mutableIntStateOf(0) }
        var showResult by remember { mutableStateOf(false) }
        var selectedAnswer by remember { mutableStateOf<Int?>(null) }
        var isAnswered by remember { mutableStateOf(false) }

        if (topic == null) {
            Text(
                text = "Topic not found",
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            )
            return@Scaffold
        }

        val questions = topic.questions

        if (questions.isEmpty()) {
            Text(
                text = "No Questions available",
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            )
            return@Scaffold
        }

        if (showResult) {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Final Result",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("Score: $score / ${questions.size}")
                Spacer(modifier = Modifier.height(16.dp))
                val percentage = (score * 100) / questions.size
                Text("Percentage: $percentage%")
                Spacer(modifier = Modifier.height(20.dp))
                if (percentage >= 70) {
                    Text(" Well Done!")
                } else {
                    Text("X You should review the topic")
                }
            }
            return@Scaffold
        }

        val question = questions.getOrNull(currentQuestionIndex)
        if (question == null) {
            Text(
                text = "Error loading question",
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            )
            return@Scaffold
        }

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = question.question,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer (modifier = Modifier.height(16.dp))

            question.options.forEachIndexed { index, option ->
                val isCorrect = index == question.correctAnswer
                val isSelected = index == selectedAnswer

                Button(
                    onClick = {
                        if (!isAnswered) {
                            selectedAnswer = index
                            isAnswered = true
                            if (isCorrect) {
                                score++
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when {
                            isAnswered && isCorrect -> MaterialTheme.colorScheme.primary
                            isAnswered && isSelected -> MaterialTheme.colorScheme.error
                            else -> MaterialTheme.colorScheme.secondary
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(option)
                }
            }

            if (isAnswered) {
                Spacer (modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (currentQuestionIndex < questions.size - 1) {
                            currentQuestionIndex++
                            selectedAnswer = null
                            isAnswered = false
                        } else {
                            showResult = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Next")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    MaterialTheme {
        val navController = rememberNavController()
        QuizScreen(
            navController = navController,
            topicId = 1
        )
    }
}