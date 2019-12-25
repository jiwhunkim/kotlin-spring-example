package com.store.service

import com.store.domain.Order
import com.store.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderService {
    @Autowired
    lateinit var orderRepository: OrderRepository

    fun save(order: Order): Order {
        return orderRepository.save(order)
    }

    fun findById(orderId: Long): Optional<Order> {
        return orderRepository.findById(orderId)
    }
}
