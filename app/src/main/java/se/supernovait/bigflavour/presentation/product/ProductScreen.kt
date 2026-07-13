package se.supernovait.bigflavour.presentation.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.data.LocalProductsDataSource
import se.supernovait.bigflavour.domain.model.product.ProductItem
import se.supernovait.bigflavour.presentation.common.container.ScreenPreviewContainer
import se.supernovait.bigflavour.presentation.common.dish_menu.DishMenu
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun ProductScreen(products: List<ProductItem>, modifier: Modifier = Modifier) {
    Column {
        Spacer(Modifier.padding(vertical = MaterialTheme.spacing.extraSmall))
        DishMenu(items = products, modifier = modifier)
    }
}

@PreviewLightDark
@Composable
fun ProductScreenPreview() {
    ScreenPreviewContainer {
        ProductScreen(LocalProductsDataSource.getProducts())
    }
}
