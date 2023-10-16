/*
 * This file is generated by jOOQ.
 */
package com.ardikapras.simplepos.domain.model.schema.tables.records


import com.ardikapras.simplepos.domain.model.schema.tables.Products
import com.ardikapras.simplepos.domain.model.schema.tables.pojos.ProductsPojo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

import java.math.BigDecimal
import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record7
import org.jooq.Row7
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
@Entity
@Table(
    name = "products",
    schema = "public"
)
open class ProductsRecord() : UpdatableRecordImpl<ProductsRecord>(Products.PRODUCTS), Record7<Long?, String?, String?, BigDecimal?, Int?, LocalDateTime?, LocalDateTime?> {

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    @get:Column(name = "product_id", nullable = false, precision = 64)
    open var productId: Long?
        set(value): Unit = set(0, value)
        get(): Long? = get(0) as Long?

    @get:Column(name = "name", nullable = false, length = 100)
    @get:NotNull
    @get:Size(max = 100)
    open var name: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    @get:Column(name = "description")
    open var description: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    @get:Column(name = "price", nullable = false, precision = 38, scale = 2)
    @get:NotNull
    open var price: BigDecimal?
        set(value): Unit = set(3, value)
        get(): BigDecimal? = get(3) as BigDecimal?

    @get:Column(name = "quantity", nullable = false, precision = 32)
    @get:NotNull
    open var quantity: Int?
        set(value): Unit = set(4, value)
        get(): Int? = get(4) as Int?

    @get:Column(name = "created_at", precision = 6)
    open var createdAt: LocalDateTime?
        set(value): Unit = set(5, value)
        get(): LocalDateTime? = get(5) as LocalDateTime?

    @get:Column(name = "updated_at", precision = 6)
    open var updatedAt: LocalDateTime?
        set(value): Unit = set(6, value)
        get(): LocalDateTime? = get(6) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row7<Long?, String?, String?, BigDecimal?, Int?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row7<Long?, String?, String?, BigDecimal?, Int?, LocalDateTime?, LocalDateTime?>
    override fun valuesRow(): Row7<Long?, String?, String?, BigDecimal?, Int?, LocalDateTime?, LocalDateTime?> = super.valuesRow() as Row7<Long?, String?, String?, BigDecimal?, Int?, LocalDateTime?, LocalDateTime?>
    override fun field1(): Field<Long?> = Products.PRODUCTS.PRODUCT_ID
    override fun field2(): Field<String?> = Products.PRODUCTS.NAME
    override fun field3(): Field<String?> = Products.PRODUCTS.DESCRIPTION
    override fun field4(): Field<BigDecimal?> = Products.PRODUCTS.PRICE
    override fun field5(): Field<Int?> = Products.PRODUCTS.QUANTITY
    override fun field6(): Field<LocalDateTime?> = Products.PRODUCTS.CREATED_AT
    override fun field7(): Field<LocalDateTime?> = Products.PRODUCTS.UPDATED_AT
    override fun component1(): Long? = productId
    override fun component2(): String? = name
    override fun component3(): String? = description
    override fun component4(): BigDecimal? = price
    override fun component5(): Int? = quantity
    override fun component6(): LocalDateTime? = createdAt
    override fun component7(): LocalDateTime? = updatedAt
    override fun value1(): Long? = productId
    override fun value2(): String? = name
    override fun value3(): String? = description
    override fun value4(): BigDecimal? = price
    override fun value5(): Int? = quantity
    override fun value6(): LocalDateTime? = createdAt
    override fun value7(): LocalDateTime? = updatedAt

    override fun value1(value: Long?): ProductsRecord {
        this.productId = value
        return this
    }

    override fun value2(value: String?): ProductsRecord {
        this.name = value
        return this
    }

    override fun value3(value: String?): ProductsRecord {
        this.description = value
        return this
    }

    override fun value4(value: BigDecimal?): ProductsRecord {
        this.price = value
        return this
    }

    override fun value5(value: Int?): ProductsRecord {
        this.quantity = value
        return this
    }

    override fun value6(value: LocalDateTime?): ProductsRecord {
        this.createdAt = value
        return this
    }

    override fun value7(value: LocalDateTime?): ProductsRecord {
        this.updatedAt = value
        return this
    }

    override fun values(value1: Long?, value2: String?, value3: String?, value4: BigDecimal?, value5: Int?, value6: LocalDateTime?, value7: LocalDateTime?): ProductsRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        return this
    }

    /**
     * Create a detached, initialised ProductsRecord
     */
    constructor(productId: Long? = null, name: String? = null, description: String? = null, price: BigDecimal? = null, quantity: Int? = null, createdAt: LocalDateTime? = null, updatedAt: LocalDateTime? = null): this() {
        this.productId = productId
        this.name = name
        this.description = description
        this.price = price
        this.quantity = quantity
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }

    /**
     * Create a detached, initialised ProductsRecord
     */
    constructor(value: ProductsPojo?): this() {
        if (value != null) {
            this.productId = value.productId
            this.name = value.name
            this.description = value.description
            this.price = value.price
            this.quantity = value.quantity
            this.createdAt = value.createdAt
            this.updatedAt = value.updatedAt
        }
    }
}