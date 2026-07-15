package se.supernovait.bigflavour.presentation.app

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
import se.supernovait.bigflavour.presentation.navigation.NavigationEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    onEvent: (event: NavigationEvent) -> Unit,
    modifier: Modifier = Modifier,
    title: String = stringResource(R.string.app_name)
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        },
        modifier = modifier,
        navigationIcon = {
            BigIconButton(
                iconId = R.drawable.ic_hamburger_menu,
                contentDescription = "App menu",
                onClick = { onEvent(NavigationEvent.ToggleNavigationDrawer) }
            )
        },
        actions = {
            BigIconButton(
                iconId = R.drawable.ic_shopping_cart,
                contentDescription = "Shopping cart",
                onClick = { onEvent(NavigationEvent.NavigateToCart) }
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun AppTopBarPreview() {
    ComponentPreviewContainer {
        AppTopBar(onEvent = { })
    }
}
