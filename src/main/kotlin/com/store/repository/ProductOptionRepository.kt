package com.store.repository

import com.store.domain.ProductOption
import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionRepository : JpaRepository<ProductOption, Long> {

}
