package com.store.controller

import com.store.domain.Order
import com.store.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@Controller
@RequestMapping("/api/orders")
class OrderController {
    @Autowired
    lateinit var orderService: OrderService

    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @PostMapping
    fun create(@RequestBody order: Order): ResponseEntity<Order> {
        val result = orderService.save(order)
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id)
                .toUri()
        return ResponseEntity.created(location).build()
    }

    @GetMapping("/{order_id}")
    fun show(@PathVariable("order_id") orderId: Long): ResponseEntity<Order> {
        val order = orderService.findById(orderId).get()
        return ResponseEntity.ok(order)
    }

    @PutMapping("/{order_id}")
    fun update(@PathVariable("order_id") orderId: Long, @RequestBody order: Order): ResponseEntity<Order> {
        val result = orderService.save(order)
        return ResponseEntity.ok(result)
    }
}
