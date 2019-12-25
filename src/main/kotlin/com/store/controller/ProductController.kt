package com.store.controller

import com.store.domain.Product
import com.store.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/api/products")
class ProductController {
    @Autowired
    lateinit var productService: ProductService

    @PostMapping
    fun create(@RequestBody product: Product): ResponseEntity<Product> {
        val result = productService.save(product)
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id)
                .toUri()
        return ResponseEntity.created(location).build()
    }

    @GetMapping("/{product_id}")
    fun show(@PathVariable("product_id") productId: Long): ResponseEntity<Product> {
        val product = productService.findById(productId).get()
        return ResponseEntity.ok(product)
    }

    @PutMapping("/{product_id}")
    fun update(@PathVariable("product_id") productId: Long, @RequestBody product: Product): ResponseEntity<Product> {
        val result = productService.save(product)
        return ResponseEntity.ok(result)
    }
}
