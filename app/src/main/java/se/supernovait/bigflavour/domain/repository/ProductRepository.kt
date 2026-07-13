package se.supernovait.bigflavour.domain.repository

import se.supernovait.bigflavour.domain.model.product.ProductCategory
import se.supernovait.bigflavour.domain.model.product.ProductItem

interface ProductRepository {
    fun getProducts(): List<ProductItem>
    fun getProductsByCategory(category: ProductCategory?): List<ProductItem>
    fun getWeeklySpecial(): List<ProductItem>
    fun getProductById(id: Long): ProductItem?
}
