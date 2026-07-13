package se.supernovait.bigflavour.presentation.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.data.LocalProductsDataSource
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.home.HomeScreen
import se.supernovait.bigflavour.presentation.navigation.NavigationEvent
import se.supernovait.bigflavour.presentation.navigation.Route

@Composable
fun AppScaffoldWithNavigationDrawer(
    navController: NavController,
    onEvent: (event: NavigationEvent) -> Unit,
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    drawerContent: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = Route.parse(backStackEntry?.destination?.route)
    val titleId = when(currentRoute) {
        Route.Home -> R.string.app_name
        is Route.Product -> backStackEntry?.toRoute<Route.Product>()?.category?.label ?: R.string.app_name
        else -> currentRoute.titleId
    }
    val title = stringResource(titleId)

    ModalNavigationDrawer(drawerContent = { drawerContent() }, drawerState = drawerState) {
        Scaffold(
            topBar = { AppTopBar(onEvent = onEvent, title = title) },
            bottomBar = { AppNavigationBar(navController) },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                content()
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun AppScaffoldWithNavigationDrawerPreview() {
    ComponentPreviewContainer {
        AppScaffoldWithNavigationDrawer(rememberNavController(), { }) {
            HomeScreen(LocalProductsDataSource.getProducts())
        }
    }
}
