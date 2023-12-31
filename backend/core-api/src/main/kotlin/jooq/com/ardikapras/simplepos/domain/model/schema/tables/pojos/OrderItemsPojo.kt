/*
 * This file is generated by jOOQ.
 */
package com.ardikapras.simplepos.domain.model.schema.tables.pojos


import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull

import java.io.Serializable
import java.math.BigDecimal


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
@Entity
@Table(
    name = "order_items",
    schema = "public"
)
data class OrderItemsPojo(
    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    @get:Column(name = "order_item_id", nullable = false, precision = 32)
    val orderItemId: Int? = null,
    @get:Column(name = "order_id", precision = 32)
    val orderId: Int? = null,
    @get:Column(name = "product_id", precision = 32)
    val productId: Int? = null,
    @get:Column(name = "quantity", nullable = false, precision = 32)
    @get:NotNull
    val quantity: Int? = null,
    @get:Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    @get:NotNull
    val unitPrice: BigDecimal? = null,
    @get:Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    @get:NotNull
    val totalPrice: BigDecimal? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("OrderItemsPojo (")

        sb.append(orderItemId)
        sb.append(", ").append(orderId)
        sb.append(", ").append(productId)
        sb.append(", ").append(quantity)
        sb.append(", ").append(unitPrice)
        sb.append(", ").append(totalPrice)

        sb.append(")")
        return sb.toString()
    }
}
