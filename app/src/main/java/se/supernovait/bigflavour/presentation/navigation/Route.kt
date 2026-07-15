package se.supernovait.bigflavour.presentation.navigation

import kotlinx.serialization.Serializable
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.domain.model.product.ProductCategory

sealed interface Route : NavigationRoute {

    @Serializable
    data object Home: Route {
        override val titleId = R.string.navigation_route_title_home
        override val iconId = R.drawable.ic_home
        override val selectedIconId = R.drawable.ic_home_filled
        override val isHome = true
    }

    @Serializable
    data class ProductMenu(val category: ProductCategory? = null): Route {
        override val titleId = R.string.navigation_route_title_product_menu
        override val iconId = R.drawable.ic_dish_menu_book
    }

    @Serializable
    data class ProductDetail(val id: Long): Route {
        override val titleId = R.string.navigation_route_title_product_detail
        override val iconId = R.drawable.ic_hand_meal
    }

    @Serializable
    data object Cart: Route {
        override val titleId = R.string.navigation_route_title_cart
        override val iconId = R.drawable.ic_shopping_cart
    }

    @Serializable
    data object Help: Route {
        override val titleId = R.string.navigation_route_title_help
        override val iconId = R.drawable.ic_help
        override val selectedIconId = R.drawable.ic_help_filled
    }

    @Serializable
    data object Settings: Route {
        override val titleId = R.string.navigation_route_title_settings
        override val iconId = R.drawable.ic_settings
        override val selectedIconId = R.drawable.ic_settings_filled
    }

    companion object {
        fun parse(route: String?, defaultRoute: Route = Home): Route {
            return when (route?.substringBefore("/")?.substringBefore("?")) {
                Home::class.qualifiedName -> Home
                ProductMenu::class.qualifiedName -> ProductMenu()
                ProductDetail::class.qualifiedName -> ProductDetail(0)
                Cart::class.qualifiedName -> Cart
                Help::class.qualifiedName -> Help
                Settings::class.qualifiedName -> Settings
                else -> defaultRoute
            }
        }
    }
}
