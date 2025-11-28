package com.example.solo.data.repository

import com.example.solo.data.models.Curso

/**
 * Repositório de Cursos - Simula endpoints da API
 * 
 * Endpoints simulados:
 * GET /api/cursos - listarTodos()
 * GET /api/cursos/{id} - buscarPorId(id)
 * POST /api/cursos - cadastrar(curso)
 */
object CursoRepository {
    
    private val cursos = mutableListOf(
        Curso(
            id = 1,
            idProfessor = 1,
            nome = "Violão Completo - Do Zero ao Avançado",
            categoria = "Violão",
            preco = 199.90,
            duracao = 12,
            numAulas = 48,
            descricao = "Aprenda violão do absoluto zero até técnicas avançadas",
            certificado = true,
            avaliacao = 4.9f
        ),
        Curso(
            id = 2,
            idProfessor = 2,
            nome = "Piano Clássico - Fundamentos",
            categoria = "Piano",
            preco = 249.90,
            duracao = 15,
            numAulas = 32,
            descricao = "Fundamentos do piano clássico para iniciantes",
            certificado = true,
            avaliacao = 4.8f
        ),
        Curso(
            id = 3,
            idProfessor = 3,
            nome = "Guitarra Rock - Técnicas Essenciais",
            categoria = "Guitarra",
            preco = 179.90,
            duracao = 10,
            numAulas = 28,
            descricao = "Técnicas de guitarra para rock e metal",
            certificado = true,
            avaliacao = 4.7f
        ),
        Curso(
            id = 4,
            idProfessor = 4,
            nome = "Bateria para Iniciantes",
            categoria = "Bateria",
            preco = 149.90,
            duracao = 8,
            numAulas = 24,
            descricao = "Primeiros passos na bateria",
            certificado = true,
            avaliacao = 4.6f
        ),
        Curso(
            id = 5,
            idProfessor = 5,
            nome = "Teoria Musical Básica",
            categoria = "Teoria",
            preco = 0.0,
            duracao = 3,
            numAulas = 10,
            descricao = "Fundamentos de teoria musical - GRATUITO",
            certificado = true,
            avaliacao = 4.5f
        )
    )
    
    // GET /api/cursos
    fun listarTodos(): List<Curso> {
        return cursos.toList()
    }
    
    // GET /api/cursos/{id}
    fun buscarPorId(id: Int): Curso? {
        return cursos.find { it.id == id }
    }
    
    // GET /api/cursos?categoria={categoria}
    fun listarPorCategoria(categoria: String): List<Curso> {
        return cursos.filter { it.categoria == categoria }
    }
    
    // POST /api/cursos
    fun cadastrar(curso: Curso): Curso {
        val novoId = (cursos.maxOfOrNull { it.id } ?: 0) + 1
        val novoCurso = curso.copy(id = novoId)
        cursos.add(novoCurso)
        return novoCurso
    }
}

