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
import se.supernovait.bigflavour.presentation.common.button.BigIconButton
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun AppNavigationDrawerContent(/*TODO: onEvent: (event: AppNavigationEvent) -> Unit*/) {
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
                    onClick = { }
                )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = MaterialTheme.spacing.small))

            Text(
                text = "Section 1",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(MaterialTheme.spacing.medium)
            )
            NavigationDrawerItem(
                label = { Text("Item 1") },
                selected = false,
                onClick = { }
            )
            NavigationDrawerItem(
                label = { Text("Item 2") },
                selected = false,
                onClick = { }
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = MaterialTheme.spacing.small))

            Text(
                text = "Section 2",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(MaterialTheme.spacing.medium)
            )
            NavigationDrawerItem(
                label = { Text("Settings") },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_settings),
                        contentDescription = "Settings menu"
                    )
                },
                onClick = { }
            )
            NavigationDrawerItem(
                label = { Text("Help and feedback") },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_help),
                        contentDescription = "Help menu"
                    )
                },
                badge = { Text("20") }, // TODO: Placeholder
                onClick = { },
            )
            Spacer(Modifier.height(MaterialTheme.spacing.medium))
        }
    }
}

@PreviewLightDark
@Composable
private fun AppNavigationDrawerContentPreview() {
    ComponentPreviewContainer {
        AppNavigationDrawerContent()
    }
}
