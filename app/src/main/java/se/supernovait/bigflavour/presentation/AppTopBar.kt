package se.supernovait.bigflavour.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.presentation.common.button.BigIconButton
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        },
        modifier = modifier,
        navigationIcon = {
            BigIconButton(
                iconId = R.drawable.ic_hamburger_menu,
                contentDescription = "App menu",
                onClick = { }
            )
        },
        actions = {
            BigIconButton(
                iconId = R.drawable.ic_shopping_cart,
                contentDescription = "Shopping cart",
                onClick = { }
            )
        }
    )
}

@PreviewLightDark
@Composable
fun AppTopBarPreview() {
    ComponentPreviewContainer {
        AppTopBar()
    }
}
