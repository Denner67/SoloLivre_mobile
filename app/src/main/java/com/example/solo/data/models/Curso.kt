package com.example.solo.data.models

data class Curso(
    val id: Int = 0,
    val idProfessor: Int,
    val nome: String,
    val categoria: String,
    val preco: Double,
    val duracao: Int, // em horas
    val numAulas: Int,
    val descricao: String? = null,
    val certificado: Boolean = true,
    val avaliacao: Float = 0f
)

