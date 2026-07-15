package se.supernovait.bigflavour.presentation.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.data.LocalProductsDataSource
import se.supernovait.bigflavour.domain.extension.filterProducts
import se.supernovait.bigflavour.domain.extension.toComparator
import se.supernovait.bigflavour.domain.model.FilterOption
import se.supernovait.bigflavour.domain.model.SortOption
import se.supernovait.bigflavour.domain.model.product.ProductItem
import se.supernovait.bigflavour.presentation.common.container.ScreenPreviewContainer
import se.supernovait.bigflavour.presentation.common.dish_menu.DishMenu
import se.supernovait.bigflavour.presentation.common.section.SectionHeader
import se.supernovait.bigflavour.presentation.navigation.NavigationEvent
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun ProductMenuScreen(
    products: List<ProductItem>,
    modifier: Modifier = Modifier,
    onEvent: (NavigationEvent) -> Unit = { },
    showFilterBar: Boolean = false
) {
    var selectedFilterOption by rememberSaveable { mutableStateOf(FilterOption.ALL) }
    var selectedSortOption by rememberSaveable { mutableStateOf(SortOption.NAME_ASC) }

    val filteredProducts by remember(products, selectedFilterOption, selectedSortOption) {
        derivedStateOf {
            products.let { list ->
                if (selectedFilterOption == FilterOption.ALL) list
                else list.filterProducts(option = selectedFilterOption)
            }.sortedWith(selectedSortOption.toComparator())
        }
    }

    Column {
        if (showFilterBar) {
            SectionHeader(
                text = stringResource(selectedFilterOption.label),
                showFilter = showFilterBar,
                selectedFilterOption = selectedFilterOption,
                onFilterOptionSelected = { selectedFilterOption = it },
                selectedSortOption = selectedSortOption,
                onSortOptionSelected = { selectedSortOption = it }
            )
        }
        DishMenu(
            items = filteredProducts,
            modifier = modifier.padding(vertical = MaterialTheme.spacing.extraSmall),
            onEvent = onEvent
        )
    }
}

@PreviewLightDark
@Composable
private fun ProductMenuScreenPreview() {
    ScreenPreviewContainer {
        ProductMenuScreen(LocalProductsDataSource.getProducts())
    }
}
