package se.supernovait.bigflavour.data

import se.supernovait.bigflavour.domain.extension.filterProducts
import se.supernovait.bigflavour.domain.model.FilterType
import se.supernovait.bigflavour.domain.model.product.ProductCategory
import se.supernovait.bigflavour.domain.model.product.ProductItem
import se.supernovait.bigflavour.domain.repository.ProductRepository

object ProductRepositoryImpl : ProductRepository {
    private val products = LocalProductsDataSource.getProducts()

    override fun getProducts(): List<ProductItem> {
        return products
    }

    override fun getProductsByCategory(category: ProductCategory?): List<ProductItem> {
        val filterType = when(category) {
            ProductCategory.FOOD -> FilterType.Food
            ProductCategory.DRINK -> FilterType.Drink
            ProductCategory.DESSERT -> FilterType.Dessert
            else -> FilterType.All
        }
        return products.filterProducts(type = filterType)
    }

    override fun getWeeklySpecial(): List<ProductItem> {
        return products.filterProducts(type = FilterType.WeeklySpecial)
    }

    override fun getProductById(id: Long): ProductItem? {
        return products.firstOrNull { it.id == id }
    }
}
