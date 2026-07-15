package se.supernovait.bigflavour.presentation.common.dish_menu

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.domain.model.product.ProductItem
import se.supernovait.bigflavour.presentation.common.cart.CartItemCounter
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.navigation.NavigationEvent
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun DishMenuItem(item: ProductItem, onEvent: (NavigationEvent) -> Unit = { }) {
    val context = LocalContext.current

    Card(
        shape = MaterialTheme.shapes.extraSmall,
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onEvent(NavigationEvent.NavigateToProductDetail(productId = item.id)) },
                onLongClick = { Toast.makeText(context, "Long press click", Toast.LENGTH_SHORT).show() },
                onDoubleClick = { Toast.makeText(context, "Double click", Toast.LENGTH_SHORT).show() }
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.small)
        ) {
            Column {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = item.description,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.spacing.extraSmall)
                        .fillMaxWidth(.75f)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "AED ${item.price}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    CartItemCounter(0, {}, {}, size = 14, color = Color.Gray) // TODO: update with state/event and add color to make it secondary and not take focus from price
                }
            }
            Image(painter = painterResource(id = item.image), contentDescription = item.imageDescription)
        }
    }
}

@PreviewLightDark
@Composable
private fun DishMenuItemPreview() {
    ComponentPreviewContainer {
        DishMenuItem(item = ProductItem.defaultItem)
    }
}
