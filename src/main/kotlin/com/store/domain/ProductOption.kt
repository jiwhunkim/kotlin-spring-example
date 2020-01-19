package com.store.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "product_options", indexes = [
    Index(name = "idx_product_options_on_product_id", columnList = "productId")
])
class ProductOption(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String = "",

        @ManyToOne(optional = false)
        @JoinColumn(name = "productId", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
        @JsonIgnoreProperties(value = ["options"])
        var product: Product?,

        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "productOption")
        @OrderBy("priority DESC")
        @JsonIgnoreProperties(value = ["product_option"])
        var items: MutableList<ProductOptionItem> = mutableListOf()
) {
    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
}
