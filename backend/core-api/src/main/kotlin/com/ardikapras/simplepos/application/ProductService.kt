package com.ardikapras.simplepos.application

import com.ardikapras.simplepos.domain.model.Product
import com.ardikapras.simplepos.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun getAllProducts(): List<Product> = productRepository.findAll()
    fun getProductById(id: Long): Product? = productRepository.findById(id)
}
