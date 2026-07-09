package se.supernovait.bigflavour.presentation.app

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.navigation.Route

@Composable
fun AppNavigationBar(navController: NavController) {
    val routes = listOf(
        Route.Home,
        Route.Help,
        Route.Settings
    )
    var selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {
        routes.forEachIndexed { index, route ->
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
                        val iconId = if (index == selectedIndex) route.selectedIconId ?: route.iconId else route.iconId
                        Icon(
                            painter = painterResource(id = iconId),
                            contentDescription = stringResource(route.titleId)
                        )
                    }
                },
                selected = index == selectedIndex,
                onClick = {
                    selectedIndex = index
                    navController.navigate(routes[index]) {
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
