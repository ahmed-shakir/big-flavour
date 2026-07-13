package se.supernovait.bigflavour.presentation.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.domain.model.product.ProductCategory
import se.supernovait.bigflavour.presentation.common.button.BigIconButton
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.navigation.NavigationEvent
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun AppNavigationDrawerContent(onEvent: (event: NavigationEvent) -> Unit) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.medium)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.spacing.medium)
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                BigIconButton(
                    iconId = R.drawable.ic_close,
                    contentDescription = "Close menu",
                    onClick = { onEvent(NavigationEvent.CloseNavigationDrawer) }
                )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = MaterialTheme.spacing.small))

            Text(
                text = stringResource(R.string.navigation_drawer_section_menu_title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(MaterialTheme.spacing.medium)
            )
            NavigationDrawerItem(
                label = { Text(stringResource(R.string.navigation_drawer_item_food_label)) },
                selected = false,
                onClick = { onEvent(NavigationEvent.NavigateToProduct(category = ProductCategory.FOOD)) }
            )
            NavigationDrawerItem(
                label = { Text(stringResource(R.string.navigation_drawer_item_drink_label)) },
                selected = false,
                onClick = { onEvent(NavigationEvent.NavigateToProduct(category = ProductCategory.DRINK)) }
            )
            NavigationDrawerItem(
                label = { Text(stringResource(R.string.navigation_drawer_item_dessert_label)) },
                selected = false,
                onClick = { onEvent(NavigationEvent.NavigateToProduct(category = ProductCategory.DESSERT)) }
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = MaterialTheme.spacing.small))

            Text(
                text = stringResource(R.string.navigation_drawer_section_application_title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(MaterialTheme.spacing.medium)
            )
            NavigationDrawerItem(
                label = { Text(stringResource(R.string.navigation_drawer_item_settings_label)) },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_settings),
                        contentDescription = stringResource(R.string.navigation_drawer_item_settings_label)
                    )
                },
                onClick = { onEvent(NavigationEvent.NavigateToSettings) }
            )
            NavigationDrawerItem(
                label = { Text(stringResource(R.string.navigation_drawer_item_help_label)) },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_help),
                        contentDescription = stringResource(R.string.navigation_drawer_item_help_label)
                    )
                },
                onClick = { onEvent(NavigationEvent.NavigateToHelp) },
            )
            Spacer(Modifier.height(MaterialTheme.spacing.medium))
        }
    }
}

@PreviewLightDark
@Composable
private fun AppNavigationDrawerContentPreview() {
    ComponentPreviewContainer {
        AppNavigationDrawerContent(onEvent = { })
    }
}
