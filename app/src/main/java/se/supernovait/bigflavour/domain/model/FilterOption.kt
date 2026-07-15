package se.supernovait.bigflavour.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import se.supernovait.bigflavour.R

enum class FilterOption(@StringRes val label: Int, @DrawableRes val icon: Int) {
    ALL(R.string.filter_option_all, R.drawable.ic_fastfood),
    FOOD(R.string.filter_option_food, R.drawable.ic_dinner),
    DRINK(R.string.filter_option_drink, R.drawable.ic_coffee),
    DESSERT(R.string.filter_option_dessert, R.drawable.ic_cake),
    WEEKLY_SPECIAL(R.string.filter_option_weekly_special, R.drawable.ic_hand_meal)
}
