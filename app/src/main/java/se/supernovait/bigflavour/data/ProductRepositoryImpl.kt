package se.supernovait.bigflavour.data

import se.supernovait.bigflavour.domain.extension.filterProducts
import se.supernovait.bigflavour.domain.model.FilterOption
import se.supernovait.bigflavour.domain.model.product.ProductCategory
import se.supernovait.bigflavour.domain.model.product.ProductItem
import se.supernovait.bigflavour.domain.repository.ProductRepository

object ProductRepositoryImpl : ProductRepository {
    private val products = LocalProductsDataSource.getProducts()

    override fun getProducts(): List<ProductItem> {
        return products
    }

    override fun getProductsByCategory(category: ProductCategory?): List<ProductItem> {
        val filterOption = when(category) {
            ProductCategory.FOOD -> FilterOption.FOOD
            ProductCategory.DRINK -> FilterOption.DRINK
            ProductCategory.DESSERT -> FilterOption.DESSERT
            else -> FilterOption.ALL
        }
        return products.filterProducts(option = filterOption)
    }

    override fun getWeeklySpecial(): List<ProductItem> {
        return products.filterProducts(option = FilterOption.WEEKLY_SPECIAL)
    }

    override fun getProductById(id: Long): ProductItem? {
        return products.firstOrNull { it.id == id }
    }
}
