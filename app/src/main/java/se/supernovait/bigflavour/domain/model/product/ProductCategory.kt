package se.supernovait.bigflavour.domain.model.product

import androidx.annotation.StringRes
import se.supernovait.bigflavour.R

enum class ProductCategory(@StringRes val label: Int) {
    FOOD(R.string.product_section_food_title),
    DRINK(R.string.product_section_drink_title),
    DESSERT(R.string.product_section_dessert_title)
}
