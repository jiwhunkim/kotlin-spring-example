package com.store.controller

import com.store.domain.ProductOption
import com.store.service.ProductOptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/api/product_options")
class ProductOptionController {
    @Autowired
    lateinit var productOptionService: ProductOptionService

    @PostMapping
    fun create(@RequestBody product: ProductOption): ResponseEntity<ProductOption> {
        val result = productOptionService.save(product)
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id)
                .toUri()
        return ResponseEntity.created(location).build()
    }

    @GetMapping("/{product_id}")
    fun show(@PathVariable("product_id") productId: Long): ResponseEntity<ProductOption> {
        val product = productOptionService.findById(productId).get()
        return ResponseEntity.ok(product)
    }

    @PutMapping("/{product_id}")
    fun update(@PathVariable("product_id") productId: Long, @RequestBody product: ProductOption): ResponseEntity<ProductOption> {
        val result = productOptionService.save(product)
        return ResponseEntity.ok(result)
    }
}
