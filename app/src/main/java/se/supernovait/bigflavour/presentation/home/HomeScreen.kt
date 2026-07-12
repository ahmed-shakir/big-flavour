package se.supernovait.bigflavour.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import kotlinx.coroutines.flow.MutableStateFlow
import se.supernovait.bigflavour.data.LocalProductsDataSource
import se.supernovait.bigflavour.presentation.common.container.ScreenPreviewContainer
import se.supernovait.bigflavour.presentation.common.dish_menu.DishMenu
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun HomeScreen() {
    val productsData = LocalProductsDataSource.getProducts() // TODO: move to viewmodel
    val productsState = MutableStateFlow(productsData)
    val products by productsState.collectAsState()

    Column {
        HomeHeroScreen()

        Column {
            WeeklySpecial()
            Spacer(Modifier.padding(vertical = MaterialTheme.spacing.extraSmall))
            DishMenu(items = products)
        }
    }
}

@PreviewLightDark
@Composable
fun HomeScreenPreview() {
    ScreenPreviewContainer {
        HomeScreen()
    }
}
