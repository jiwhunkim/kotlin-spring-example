package com.store.service

import com.store.domain.OrderProduct
import com.store.repository.OrderProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderProductService {
    @Autowired
    lateinit var orderProductRepository: OrderProductRepository

    fun save(orderProduct: OrderProduct): OrderProduct {
        return orderProductRepository.save(orderProduct)
    }

    fun findById(orderProductId: Long): Optional<OrderProduct> {
        return orderProductRepository.findById(orderProductId)
    }
}
