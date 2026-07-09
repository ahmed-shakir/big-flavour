package se.supernovait.bigflavour.presentation.app

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.presentation.common.button.BigIconButton
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(scope: CoroutineScope, drawerState: DrawerState, modifier: Modifier = Modifier, title: String = stringResource(R.string.app_name)) {
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
                onClick = {
                    scope.launch {
                        if (drawerState.isClosed) {
                            drawerState.open()
                        } else {
                            drawerState.close()
                        }
                    }
                }
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
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        AppTopBar(scope, drawerState)
    }
}
