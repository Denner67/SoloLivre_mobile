package com.example.solo.data.repository

import com.example.solo.data.models.Instrumento

/**
 * Repositório de Instrumentos - Simula endpoints da API
 * 
 * Endpoints simulados:
 * GET /api/instrumentos - listarTodos()
 * GET /api/instrumentos/{id} - buscarPorId(id)
 * POST /api/instrumentos - cadastrar(instrumento)
 */
object InstrumentoRepository {
    
    private val instrumentos = mutableListOf(
        Instrumento(
            id = 1,
            nome = "Violão Yamaha C40",
            categoria = "Violões",
            preco = 649.90,
            descricao = "Violão clássico para iniciantes",
            estoque = 15,
            avaliacao = 4.8f
        ),
        Instrumento(
            id = 2,
            nome = "Teclado Casio CTK-3500",
            categoria = "Teclados",
            preco = 799.90,
            descricao = "Teclado 61 teclas com ritmos",
            estoque = 8,
            avaliacao = 4.6f
        ),
        Instrumento(
            id = 3,
            nome = "Bateria Pearl Export",
            categoria = "Baterias",
            preco = 3499.90,
            descricao = "Bateria acústica completa",
            estoque = 3,
            avaliacao = 4.9f
        ),
        Instrumento(
            id = 4,
            nome = "Trompete Yamaha YTR-2330",
            categoria = "Sopro",
            preco = 1899.90,
            descricao = "Trompete em Sib para estudantes",
            estoque = 5,
            avaliacao = 4.7f
        ),
        Instrumento(
            id = 5,
            nome = "Guitarra Fender Stratocaster",
            categoria = "Guitarras",
            preco = 2499.90,
            descricao = "Guitarra elétrica clássica",
            estoque = 6,
            avaliacao = 4.9f
        ),
        Instrumento(
            id = 6,
            nome = "Cordas Elixir Violão",
            categoria = "Acessórios",
            preco = 89.90,
            descricao = "Jogo de cordas de aço",
            estoque = 50,
            avaliacao = 4.8f
        )
    )
    
    // GET /api/instrumentos
    fun listarTodos(): List<Instrumento> {
        return instrumentos.toList()
    }
    
    // GET /api/instrumentos/{id}
    fun buscarPorId(id: Int): Instrumento? {
        return instrumentos.find { it.id == id }
    }
    
    // GET /api/instrumentos?categoria={categoria}
    fun listarPorCategoria(categoria: String): List<Instrumento> {
        return instrumentos.filter { it.categoria == categoria }
    }
    
    // POST /api/instrumentos
    fun cadastrar(instrumento: Instrumento): Instrumento {
        val novoId = (instrumentos.maxOfOrNull { it.id } ?: 0) + 1
        val novoInstrumento = instrumento.copy(id = novoId)
        instrumentos.add(novoInstrumento)
        return novoInstrumento
    }
}

