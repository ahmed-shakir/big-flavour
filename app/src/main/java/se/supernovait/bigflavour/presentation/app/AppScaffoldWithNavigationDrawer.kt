package se.supernovait.bigflavour.presentation.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.home.HomeScreen
import se.supernovait.bigflavour.presentation.navigation.Route

@Composable
fun AppScaffoldWithNavigationDrawer(navController: NavController, drawerContent: @Composable () -> Unit = {}, content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = Route.parse(backStackEntry?.destination?.route)
    val titleId = if (currentRoute.isHome) R.string.app_name else currentRoute.titleId
    val title = stringResource(titleId)

    ModalNavigationDrawer(
        drawerContent = { drawerContent() },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = { AppTopBar(scope = scope, drawerState = drawerState, title = title) },
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
        AppScaffoldWithNavigationDrawer(rememberNavController()) {
            HomeScreen()
        }
    }
}
