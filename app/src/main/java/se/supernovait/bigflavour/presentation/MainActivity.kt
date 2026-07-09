package se.supernovait.bigflavour.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import se.supernovait.bigflavour.presentation.app.AppNavigationDrawerContent
import se.supernovait.bigflavour.presentation.app.AppScaffoldWithNavigationDrawer
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.help.HelpScreen
import se.supernovait.bigflavour.presentation.home.HomeScreen
import se.supernovait.bigflavour.presentation.navigation.Route
import se.supernovait.bigflavour.presentation.settings.SettingsScreen
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BigFlavourTheme {
                val navController = rememberNavController()

                AppScaffoldWithNavigationDrawer(navController = navController, drawerContent = { AppNavigationDrawerContent() }) {
                    NavHost(navController = navController, startDestination = Route.Home) {
                        composable<Route.Home> {
                            HomeScreen()
                        }
                        composable<Route.Help> {
                            HelpScreen()
                        }
                        composable<Route.Settings> {
                            SettingsScreen()
                        }
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun AppScaffoldPreview() {
    ComponentPreviewContainer {
        AppScaffoldWithNavigationDrawer(rememberNavController()) {
            HomeScreen()
        }
    }
}
