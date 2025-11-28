package com.example.solo.data.models

data class Professor(
    val id: Int = 0,
    val nome: String,
    val especialidade: String,
    val bio: String? = null,
    val avaliacao: Float = 0f
)

