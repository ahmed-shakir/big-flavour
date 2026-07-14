package se.supernovait.bigflavour.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.coroutines.launch
import se.supernovait.bigflavour.data.LocalProductsDataSource
import se.supernovait.bigflavour.data.ProductRepositoryImpl
import se.supernovait.bigflavour.presentation.app.AppNavigationDrawerContent
import se.supernovait.bigflavour.presentation.app.AppScaffoldWithNavigationDrawer
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.help.HelpScreen
import se.supernovait.bigflavour.presentation.home.HomeScreen
import se.supernovait.bigflavour.presentation.navigation.NavigationEvent
import se.supernovait.bigflavour.presentation.navigation.Route
import se.supernovait.bigflavour.presentation.product.ProductDetailScreen
import se.supernovait.bigflavour.presentation.product.ProductScreen
import se.supernovait.bigflavour.presentation.settings.SettingsScreen
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // TODO: Implement sorting and filter from "all" products screen
            // TODO: Add products menu to "all" products screen
            // TODO: Add app (error) (channel) events
            // TODO: Add Events Observer
            // TODO: Add ViewModel
            // TODO: Make sure all buttons/clickable work and is handled
            // TODO: Add tests


            BigFlavourTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                val productRepository = ProductRepositoryImpl // TODO: move to viewmodel

                fun navigate(route: Route) {
                    navController.navigate(route) {
                        launchSingleTop = true
                    }

                    if (drawerState.isOpen) {
                        scope.launch {
                            drawerState.close()
                        }
                    }
                }

                fun handleEvent(event: NavigationEvent) {
                    when(event) {
                        is NavigationEvent.NavigateToProduct -> {
                            navigate(Route.Product(event.category))
                        }
                        is NavigationEvent.NavigateToProductDetail -> {
                            navigate(Route.ProductDetail(event.productId))
                        }
                        NavigationEvent.NavigateToSettings -> {
                            navigate(Route.Settings)
                        }
                        NavigationEvent.NavigateToHelp -> {
                            navigate(Route.Help)
                        }
                        NavigationEvent.NavigateToCart -> {
                            Toast.makeText(this, "Navigating to Cart", Toast.LENGTH_SHORT).show()
                        }
                        NavigationEvent.ToggleNavigationDrawer -> {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }
                        NavigationEvent.CloseNavigationDrawer -> {
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    }
                }

                AppScaffoldWithNavigationDrawer(
                    navController = navController,
                    onEvent = { event -> handleEvent(event) },
                    drawerState = drawerState,
                    drawerContent = {
                        AppNavigationDrawerContent(onEvent = { event -> handleEvent(event)})
                    }
                ) {
                    NavHost(navController = navController, startDestination = Route.Home) {
                        composable<Route.Home> {
                            HomeScreen(products = productRepository.getWeeklySpecial(), onEvent = { event ->  handleEvent(event) })
                        }
                        composable<Route.Product> {
                            val category = it.toRoute<Route.Product>().category

                            ProductScreen(products = productRepository.getProductsByCategory(category), onEvent = { event ->  handleEvent(event) })
                        }
                        composable<Route.ProductDetail> {
                            val id = it.toRoute<Route.ProductDetail>().id
                            val product = productRepository.getProductById(id)

                            if (product == null) {
                                Toast.makeText(this@MainActivity, "Product not found", Toast.LENGTH_SHORT).show()
                            } else {
                                ProductDetailScreen(product = product)
                            }
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
        AppScaffoldWithNavigationDrawer(rememberNavController(), { }) {
            HomeScreen(LocalProductsDataSource.getProducts())
        }
    }
}
