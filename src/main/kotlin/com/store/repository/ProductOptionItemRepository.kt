package com.store.repository

import com.store.domain.ProductOptionItem
import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionItemRepository : JpaRepository<ProductOptionItem, Long> {

}
