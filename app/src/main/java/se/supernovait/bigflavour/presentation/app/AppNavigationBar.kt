package se.supernovait.bigflavour.presentation.app

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.navigation.Route

@Composable
fun AppNavigationBar(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = Route.parse(backStackEntry?.destination?.route)

    val routes = listOf(
        Route.Home,
        Route.ProductMenu(),
        Route.Settings
    )

    NavigationBar {
        routes.forEach { route ->
            NavigationBarItem(
                label = { Text(text = stringResource(route.titleId)) },
                icon = {
                    BadgedBox(
                        badge = {
                            if (route.badgeCount != null) {
                                Badge {
                                    Text(text = route.badgeCount.toString())
                                }
                            } else if (route.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        val iconId = if (currentRoute == route) route.selectedIconId ?: route.iconId else route.iconId
                        val tint = if (currentRoute == route) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface
                        Icon(
                            painter = painterResource(id = iconId),
                            contentDescription = stringResource(route.titleId),
                            tint = tint,
                        )
                    }
                },
                selected = currentRoute == route,
                colors = NavigationBarItemDefaults.colors(indicatorColor = MaterialTheme.colorScheme.surface),
                onClick = {
                    navController.navigate(route) {
                        popUpTo(Route.Home)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@PreviewLightDark
@Composable
fun AppNavigationBarPreview() {
    ComponentPreviewContainer {
        AppNavigationBar(navController = rememberNavController())
    }
}
