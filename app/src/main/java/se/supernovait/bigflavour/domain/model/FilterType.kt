package se.supernovait.bigflavour.domain.model

sealed interface FilterType {
    data object All : FilterType
    data object Food : FilterType
    data object Drink : FilterType
    data object Dessert : FilterType
}
