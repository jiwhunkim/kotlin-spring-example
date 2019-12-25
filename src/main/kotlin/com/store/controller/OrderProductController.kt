package com.store.controller

import com.store.domain.OrderProduct
import com.store.service.OrderProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@Controller
@RequestMapping("/api/orderProduct_products")
class OrderProductController {
    @Autowired
    lateinit var orderProductService: OrderProductService

    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @PostMapping
    fun create(@RequestBody orderProduct: OrderProduct): ResponseEntity<OrderProduct> {
        val result = orderProductService.save(orderProduct)
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id)
                .toUri()
        return ResponseEntity.created(location).build()
    }

    @GetMapping("/{orderProduct_id}")
    fun show(@PathVariable("orderProduct_id") orderProductId: Long): ResponseEntity<OrderProduct> {
        val orderProduct = orderProductService.findById(orderProductId).get()
        return ResponseEntity.ok(orderProduct)
    }

    @PutMapping("/{orderProduct_id}")
    fun update(@PathVariable("orderProduct_id") orderProductId: Long, @RequestBody orderProduct: OrderProduct): ResponseEntity<OrderProduct> {
        val result = orderProductService.save(orderProduct)
        return ResponseEntity.ok(result)
    }
}
