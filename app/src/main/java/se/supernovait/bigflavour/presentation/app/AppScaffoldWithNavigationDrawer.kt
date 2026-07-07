package se.supernovait.bigflavour.presentation.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.home.HomeScreen

@Composable
fun AppScaffoldWithNavigationDrawer(drawerContent: @Composable () -> Unit = {}, content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = { drawerContent() },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = { AppTopBar(scope, drawerState) },
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
        AppScaffoldWithNavigationDrawer() {
            HomeScreen()
        }
    }
}
