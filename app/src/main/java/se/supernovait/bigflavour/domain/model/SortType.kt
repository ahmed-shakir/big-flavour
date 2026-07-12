package se.supernovait.bigflavour.domain.model

sealed interface SortType {
    data object Alphabetically : SortType
    data object PriceAsc : SortType
    data object PriceDesc : SortType
}
