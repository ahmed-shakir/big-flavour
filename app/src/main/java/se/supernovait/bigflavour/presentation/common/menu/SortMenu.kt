package se.supernovait.bigflavour.presentation.common.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.domain.model.SortOption
import se.supernovait.bigflavour.presentation.common.button.BigIconButton
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer

@Composable
fun SortMenu(
    selectedSortOption: SortOption,
    onSortOptionSelected: (SortOption) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        BigIconButton(
            iconId = R.drawable.ic_sort,
            contentDescription = stringResource(R.string.sort_title),
            onClick = { expanded = true }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            SortOption.entries.forEach { sortOption ->
                DropdownMenuItem(
                    text = { Text(stringResource(sortOption.label)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(sortOption.icon),
                            contentDescription = "${stringResource(R.string.filter_title)} ${stringResource(sortOption.label)}"
                        )
                    },
                    trailingIcon = {
                        if (sortOption == selectedSortOption) {
                            Icon(
                                painter = painterResource(R.drawable.ic_check),
                                contentDescription = "${stringResource(R.string.filter_title)} ${stringResource(R.string.action_selected)}"
                            )
                        }
                    },
                    onClick = {
                        onSortOptionSelected(sortOption)
                        expanded = false
                    }
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun SortMenuPreview() {
    ComponentPreviewContainer {
        SortMenu(selectedSortOption = SortOption.NAME_ASC, onSortOptionSelected = { })
    }
}
