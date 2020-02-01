package com.store.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
        @javax.persistence.Id
        @org.springframework.data.annotation.Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var guid: String? = null,
        var buyerName: String = "",

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, mappedBy = "order")
        @JsonIgnoreProperties(value = ["order"])
        var orderProducts: MutableList<OrderProduct> = mutableListOf()
) {
        @CreationTimestamp
        var createdAt: LocalDateTime = LocalDateTime.now()
        @UpdateTimestamp
        var updatedAt: LocalDateTime = LocalDateTime.now()
}
