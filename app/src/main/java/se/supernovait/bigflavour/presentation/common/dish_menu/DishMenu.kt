package se.supernovait.bigflavour.presentation.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.domain.model.DishMenuItemData
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun DishMenu(items: List<DishMenuItemData>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        items.forEachIndexed { index, item ->
            DishMenuItem(
                title = item.title,
                body = item.body,
                price = item.price,
                imageResourceId = item.imageResourceId,
                imageDescription = item.imageDescription
            )

            if (index < items.lastIndex) {
                HorizontalDivider(
                    thickness = MaterialTheme.spacing.divider,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = MaterialTheme.spacing.small)
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun DishMenuPreview() {
    BigFlavourTheme {
        DishMenu(
            items = listOf(
                DishMenuItemData("Greek Salad", "Crispy lettuce, peppers, olives...", 12.99f, R.drawable.menu_item_greek_salad, "Greek Salad Image"),
                DishMenuItemData("Lentil Soup", "Comfort in a bowl...", 8.99f, R.drawable.menu_item_greek_salad, "Lentil Soup Image")
            )
        )
    }
}
