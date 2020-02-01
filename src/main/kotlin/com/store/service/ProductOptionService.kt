package com.store.service

import com.store.domain.ProductOption
import com.store.repository.jpa.ProductOptionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductOptionService(val productOptionRepository: ProductOptionRepository) {
    fun save(productOption: ProductOption): ProductOption {
        return productOptionRepository.save(productOption)
    }

    fun findById(productOptionId: Long): Optional<ProductOption> {
        return productOptionRepository.findById(productOptionId)
    }
}
