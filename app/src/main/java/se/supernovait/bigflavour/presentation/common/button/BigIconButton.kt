package se.supernovait.bigflavour.presentation.common.button

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun BigIconButton(
    iconId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    size: Dp = 24.dp,
    color: Color = MaterialTheme.colorScheme.onSurface,
    contentDescription: String? = null
) {
    if (label.isNullOrEmpty()) {
        IconButton(onClick = onClick) {
            Icon(
                painter = painterResource(iconId),
                contentDescription = contentDescription,
                tint = color,
                modifier = modifier.size(size)
            )
        }
    } else {
        IconTextButton(
            text = label,
            iconId = iconId,
            onClick = onClick,
            modifier = modifier,
            size = size,
            color = color,
            contentDescription = contentDescription
        )
    }
}

@Composable
private fun IconTextButton(
    text: String,
    iconId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    color: Color = MaterialTheme.colorScheme.onSurface,
    contentDescription: String? = null
) {
    TextButton(onClick = onClick) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = contentDescription,
            tint = color,
            modifier = modifier.size(size)
        )
        Text(
            text = text,
            color = color,
            style = MaterialTheme.typography.titleMedium,
            fontSize = size.value.minus(2).sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(start = MaterialTheme.spacing.extraSmall)
        )
    }
}

@PreviewLightDark
@Composable
private fun BigIconButtonPreview() {
    ComponentPreviewContainer {
        BigIconButton(iconId = R.drawable.ic_shopping_cart, onClick = { })
    }
}

@PreviewLightDark
@Composable
private fun IconTextButtonPreview() {
    ComponentPreviewContainer {
        IconTextButton(text = "Cart", iconId = R.drawable.ic_shopping_cart, onClick = { })
    }
}
