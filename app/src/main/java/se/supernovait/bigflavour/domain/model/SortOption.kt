package se.supernovait.bigflavour.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import se.supernovait.bigflavour.R

enum class SortOption(@StringRes val label: Int, @DrawableRes val icon: Int) {
    NAME_ASC(R.string.sort_option_name_asc, R.drawable.ic_sort_alpha),
    NAME_DESC(R.string.sort_option_name_desc, R.drawable.ic_sort_alpha),
    PRICE_ASC(R.string.sort_option_price_asc, R.drawable.ic_sort_123),
    PRICE_DESC(R.string.sort_option_price_desc, R.drawable.ic_sort_123)
}
