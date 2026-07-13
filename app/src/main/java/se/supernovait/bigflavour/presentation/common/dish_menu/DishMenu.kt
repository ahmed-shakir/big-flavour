package se.supernovait.bigflavour.presentation.common.dish_menu

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.data.LocalProductsDataSource
import se.supernovait.bigflavour.domain.model.product.ProductItem
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun DishMenu(items: List<ProductItem>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        itemsIndexed(items) { index, item ->
            DishMenuItem(
                title = item.title,
                body = item.description,
                price = item.price,
                imageResourceId = item.image,
                imageDescription = item.imageDescription
            )

            if (index < items.lastIndex) {
                Spacer(Modifier.padding(vertical = MaterialTheme.spacing.extraSmall))
            }
        }
    }
}

@PreviewLightDark
@Composable
fun DishMenuPreview() {
    ComponentPreviewContainer {
        DishMenu(
            items = LocalProductsDataSource.getProducts()
        )
    }
}
