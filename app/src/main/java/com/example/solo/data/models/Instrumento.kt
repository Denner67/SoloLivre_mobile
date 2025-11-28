package com.example.solo.data.models

data class Instrumento(
    val id: Int = 0,
    val nome: String,
    val categoria: String,
    val preco: Double,
    val descricao: String? = null,
    val estoque: Int = 0,
    val avaliacao: Float = 0f,
    val imagemUrl: String? = null
)

