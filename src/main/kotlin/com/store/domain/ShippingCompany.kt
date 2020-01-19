package com.store.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "shipping_companies")
class ShippingCompany(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String = "",

        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "shippingCompany")
        @JsonIgnoreProperties(value = ["shipping_company"])
        var shippings: MutableList<Shipping> = mutableListOf()
) {
    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
}
