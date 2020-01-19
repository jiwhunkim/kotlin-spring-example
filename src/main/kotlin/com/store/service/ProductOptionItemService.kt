package com.store.service

import com.store.domain.ProductOptionItem
import com.store.repository.ProductOptionItemRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductOptionItemService(val productOptionItemRepository: ProductOptionItemRepository) {
    fun save(productOptionItem: ProductOptionItem): ProductOptionItem {
        return productOptionItemRepository.save(productOptionItem)
    }

    fun findById(productOptionItemId: Long): Optional<ProductOptionItem> {
        return productOptionItemRepository.findById(productOptionItemId)
    }
}
