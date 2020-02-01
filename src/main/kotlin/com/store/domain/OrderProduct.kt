package com.store.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "order_products")
class OrderProduct(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var quantity: Int = 0,
        var amount: Int = 0,
        var productOptionName: String? = null,
        var productOptionItemName: String? = null,

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "orderId", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
        @JsonIgnoreProperties(value = ["orderProducts"])
        var order: Order?,

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "productId", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
        @JsonIgnoreProperties(value = ["options"])
        var product: Product?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "productOptionItemId", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
        @JsonIgnoreProperties(value = ["product_option"])
        var productOptionItem: ProductOptionItem?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "shippingId", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
        @JsonIgnoreProperties(value = ["order_products"])
        var shipping: Shipping?
) {
        @CreationTimestamp
        var createdAt: LocalDateTime = LocalDateTime.now()
        @UpdateTimestamp
        var updatedAt: LocalDateTime = LocalDateTime.now()
}
