package se.supernovait.bigflavour.domain.model.product

import androidx.annotation.DrawableRes

data class ProductItem(
    val id: Long,
    val title: String,
    val description: String,
    val category: ProductCategory,
    val price: Double,
    @DrawableRes val image: Int,
    val imageDescription: String = title,
    val isWeeklySpecial: Boolean = false
) {
    companion object {
        val defaultItem = ProductItem(
            id = 0,
            title = "",
            description = "",
            category = ProductCategory.FOOD,
            price = 0.0,
            image = 0
        )
    }
}
