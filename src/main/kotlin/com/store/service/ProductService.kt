package com.store.service

import com.store.domain.Product
import com.store.repository.jpa.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(val productRepository: ProductRepository) {
    fun save(product: Product): Product {
        for (productOption in product.options) {
            productOption.product = product

            for (productOptionItems in productOption.items) {
                productOptionItems.productOption = productOption
            }
        }
        return productRepository.save(product)
    }

    fun findById(productId: Long): Optional<Product> {
        return productRepository.findById(productId)
    }
}
