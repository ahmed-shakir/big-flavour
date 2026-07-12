package se.supernovait.bigflavour.domain.extension

import se.supernovait.bigflavour.domain.model.FilterType
import se.supernovait.bigflavour.domain.model.SortType
import se.supernovait.bigflavour.domain.model.product.ProductCategory
import se.supernovait.bigflavour.domain.model.product.ProductItem

fun List<ProductItem>.filterProducts(type: FilterType): List<ProductItem> {
    return when (type) {
        FilterType.All -> this
        FilterType.Food -> filter { it.category == ProductCategory.FOOD }
        FilterType.Drink -> filter { it.category == ProductCategory.DRINK }
        FilterType.Dessert -> filter { it.category == ProductCategory.DESSERT }
    }
}

fun List<ProductItem>.sortProducts(type: SortType): List<ProductItem> {
    return when (type) {
        SortType.Alphabetically -> sortedBy { it.title }
        SortType.PriceAsc -> sortedBy { it.price }
        SortType.PriceDesc -> sortedByDescending { it.price }
    }
}
