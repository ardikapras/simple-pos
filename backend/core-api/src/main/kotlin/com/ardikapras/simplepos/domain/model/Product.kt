package com.ardikapras.simplepos.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime

data class Product(
    val productId: Long,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val quantity: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
