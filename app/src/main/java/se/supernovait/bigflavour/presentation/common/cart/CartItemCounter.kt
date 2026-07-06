package se.supernovait.bigflavour.presentation.common.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.presentation.common.button.BigIconButton
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun CartItemCounter(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier,
    size: Int = 16
) {
    val iconSize = (size+2).dp

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(MaterialTheme.spacing.tiny)
    ) {
        if (count > 0) {
            BigIconButton(
                iconId = R.drawable.ic_remove,
                onClick = onDecrement,
                size = iconSize,
                contentDescription = "Decrement quantity"
            )
            Text(
                text = "$count",
                style = MaterialTheme.typography.titleMedium,
                fontSize = size.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.extraSmall)
            )
            BigIconButton(
                iconId = R.drawable.ic_add,
                onClick = onIncrement,
                size = iconSize,
                contentDescription = "Increment quantity"
            )
        } else {
            BigIconButton(
                label = stringResource(R.string.cart_button_add),
                iconId = R.drawable.ic_add_shopping_cart,
                onClick = onIncrement,
                size = iconSize,
                contentDescription = "Add item to cart"
            )
        }
    }
}

@PreviewLightDark
@Composable
fun CartItemCounterPreview() {
    ComponentPreviewContainer {
        Column {
            CartItemCounter(1, {}, {})
        }
    }
}

@PreviewLightDark
@Composable
fun CartItemCounterEmptyPreview() {
    ComponentPreviewContainer {
        Column {
            CartItemCounter(0, {}, {})
        }
    }
}
