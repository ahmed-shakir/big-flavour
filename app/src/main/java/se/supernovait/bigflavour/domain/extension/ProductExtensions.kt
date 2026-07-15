package se.supernovait.bigflavour.domain.extension

import se.supernovait.bigflavour.domain.model.FilterOption
import se.supernovait.bigflavour.domain.model.SortOption
import se.supernovait.bigflavour.domain.model.product.ProductCategory
import se.supernovait.bigflavour.domain.model.product.ProductItem

fun List<ProductItem>.filterProducts(option: FilterOption): List<ProductItem> = when (option) {
    FilterOption.ALL -> this
    FilterOption.FOOD -> filter { it.category == ProductCategory.FOOD }
    FilterOption.DRINK -> filter { it.category == ProductCategory.DRINK }
    FilterOption.DESSERT -> filter { it.category == ProductCategory.DESSERT }
    FilterOption.WEEKLY_SPECIAL -> filter { it.isWeeklySpecial }
}

fun SortOption.toComparator(): Comparator<ProductItem> = when (this) {
    SortOption.NAME_ASC -> compareBy { it.title }
    SortOption.NAME_DESC -> compareByDescending { it.title }
    SortOption.PRICE_ASC -> compareBy { it.price }
    SortOption.PRICE_DESC -> compareByDescending { it.price }
}
