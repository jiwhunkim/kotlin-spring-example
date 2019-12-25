package com.store.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "shippings")
data class Shipping(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        var trackingNum: String? = null,

        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "shipping")
        @JsonIgnoreProperties(value = ["shipping"])
        var orderProducts: MutableList<OrderProduct> = mutableListOf(),

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "shippingCompanyId", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
        @JsonIgnoreProperties(value = ["shippings"])
        var shippingCompany: ShippingCompany? = null) {
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now()
    @UpdateTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now()
}

