package se.supernovait.bigflavour.presentation.navigation

import se.supernovait.bigflavour.domain.model.product.ProductCategory

sealed interface NavigationEvent {
    data class NavigateToProduct(val category: ProductCategory): NavigationEvent
    data class NavigateToProductDetail(val productId: Long): NavigationEvent
    data object NavigateToSettings: NavigationEvent
    data object NavigateToHelp: NavigationEvent
    data object NavigateToCart: NavigationEvent
    data object ToggleNavigationDrawer: NavigationEvent
    data object CloseNavigationDrawer: NavigationEvent
}
