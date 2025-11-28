package com.example.solo.data.models

enum class TipoItem { INSTRUMENTO, CURSO }
enum class StatusCompra { PENDENTE, PAGO, ENVIADO, ENTREGUE, CANCELADO }

data class Compra(
    val id: Int = 0,
    val idUsuario: Int,
    val idItem: Int,
    val tipoItem: TipoItem,
    val quantidade: Int = 1,
    val valorTotal: Double,
    val dataCompra: Long = System.currentTimeMillis(),
    val status: StatusCompra = StatusCompra.PENDENTE
)

