package se.supernovait.bigflavour.presentation.common.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.domain.model.FilterOption
import se.supernovait.bigflavour.domain.model.SortOption
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.common.menu.FilterMenu
import se.supernovait.bigflavour.presentation.common.menu.SortMenu
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun SectionHeader(
    text: String,
    showFilter: Boolean = false,
    selectedFilterOption: FilterOption = FilterOption.ALL,
    onFilterOptionSelected: (FilterOption) -> Unit = { },
    selectedSortOption: SortOption = SortOption.NAME_ASC,
    onSortOptionSelected: (SortOption) -> Unit = { }
) {
    Card(shape = MaterialTheme.shapes.extraSmall, modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(MaterialTheme.spacing.small)
            )
            Row {
                if (showFilter) {
                    FilterMenu(
                        selectedFilterOption = selectedFilterOption,
                        onFilterOptionSelected = onFilterOptionSelected
                    )
                }
                SortMenu(
                    selectedSortOption = selectedSortOption,
                    onSortOptionSelected = onSortOptionSelected
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun SectionHeaderPreview() {
    ComponentPreviewContainer {
        SectionHeader(text = "Section Header", showFilter = true)
    }
}
@PreviewLightDark
@Composable
fun SectionHeaderNoFilteringPreview() {
    ComponentPreviewContainer {
        SectionHeader(text = "Section Header", showFilter = false)
    }
}
