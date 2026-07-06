package se.supernovait.bigflavour.domain.model

data class DishMenuItemData(
    val title: String,
    val body: String,
    val price: Double,
    val imageResourceId: Int,
    val imageDescription: String = ""
)
