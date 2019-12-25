package com.store.repository

import com.store.domain.OrderProduct
import org.springframework.data.jpa.repository.JpaRepository

interface OrderProductRepository : JpaRepository<OrderProduct, Long> {

}
