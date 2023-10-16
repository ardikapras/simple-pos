package com.ardikapras.simplepos.infrastructure.web.controller

import com.ardikapras.simplepos.application.ProductService
import com.ardikapras.simplepos.domain.model.Product
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getAllProducts(): List<Product> = productService.getAllProducts()

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): Product? = productService.getProductById(id)
}
