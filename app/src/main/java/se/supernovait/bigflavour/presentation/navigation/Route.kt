package se.supernovait.bigflavour.presentation.navigation

import kotlinx.serialization.Serializable
import se.supernovait.bigflavour.R

sealed interface Route : NavigationRoute {

    @Serializable
    data object Home: Route {
        override val titleId = R.string.navigation_route_title_home
        override val iconId = R.drawable.ic_home
        override val selectedIconId = R.drawable.ic_home_filled
        override val isHome = true
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
                Help::class.qualifiedName -> Help
                Settings::class.qualifiedName -> Settings
                else -> defaultRoute
            }
        }
    }
}
