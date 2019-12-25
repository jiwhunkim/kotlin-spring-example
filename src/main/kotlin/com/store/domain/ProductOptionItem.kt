package com.store.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "product_option_items")
data class ProductOptionItem(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String = "",
        var price: Int = 0,

        @ManyToOne(optional = false)
        @JoinColumn(name = "productOptionId", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
        @JsonIgnoreProperties(value = ["items", "product"])
        var productOption: ProductOption?
) {
    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
}
