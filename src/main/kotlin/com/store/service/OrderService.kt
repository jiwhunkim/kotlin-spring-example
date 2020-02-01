package com.store.service

import com.store.domain.Order
import com.store.repository.jpa.OrderRepository
import com.store.repository.reactive.ReactiveOrderRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class OrderService(val orderRepository: OrderRepository, val reactiveOrderRepository: ReactiveOrderRepository) {

    fun save(order: Order): Order {
        return orderRepository.save(order)
    }

    fun findById(orderId: Long): Optional<Order> {
        return orderRepository.findById(orderId)
    }

    fun findByIdRx(orderId: Long): Mono<Order> {
        return reactiveOrderRepository.findByIdRx(orderId)
    }
}
