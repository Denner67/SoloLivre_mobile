package com.example.solo.data.models

data class Usuario(
    val id: Int = 0,
    val nome: String,
    val email: String,
    val senha: String,
    val telefone: String? = null,
    val dataCadastro: Long = System.currentTimeMillis()
)

