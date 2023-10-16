package com.ardikapras.simplepos.domain.repository

import com.ardikapras.simplepos.domain.model.Product
import com.ardikapras.simplepos.domain.model.schema.tables.references.PRODUCTS
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ProductRepository(
    @Autowired private val ctx: DSLContext,
) {
    fun findAll(): List<Product> = ctx
        .selectFrom(PRODUCTS)
        .fetch()
        .map { r -> r.into(Product::class.java) }

    fun findById(id: Long): Product? = ctx
        .selectFrom(PRODUCTS)
        .where(PRODUCTS.PRODUCT_ID.eq(id))
        .fetchOne()
        ?.into(Product::class.java)
}
