package com.example.kotlinlearningapp.data.model

data class Topic(
    val id: Int,
    val title: String,
    val theory: String,
    val code: String,
    val questions: List<Question> = emptyList()
)