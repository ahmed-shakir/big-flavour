package se.supernovait.bigflavour.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.presentation.app.AppNavigationDrawerContent
import se.supernovait.bigflavour.presentation.app.AppScaffoldWithNavigationDrawer
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.home.HomeScreen
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BigFlavourTheme {
                AppScaffoldWithNavigationDrawer(drawerContent = { AppNavigationDrawerContent() }) {
                    HomeScreen()
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun AppScaffoldPreview() {
    ComponentPreviewContainer {
        AppScaffoldWithNavigationDrawer() {
            HomeScreen()
        }
    }
}
