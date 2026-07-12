package se.supernovait.bigflavour.domain.model.product

import androidx.annotation.DrawableRes

data class ProductItem(
    val title: String,
    val description: String,
    val category: ProductCategory,
    val price: Double,
    @DrawableRes val image: Int,
    val imageDescription: String = ""
) {
    companion object {
        val defaultItem = ProductItem(
            title = "",
            description = "",
            category = ProductCategory.FOOD,
            price = 0.0,
            image = 0
        )
    }
}
