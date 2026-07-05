package se.supernovait.bigflavour.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun HomeHeroScreen() {
    val context = LocalContext.current
    val defaultPadding = MaterialTheme.spacing.paddingMedium
    val indentPadding = 2.dp

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(all = defaultPadding)
    ) {
        Text(
            text = stringResource(R.string.main_section_title),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.main_section_location),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = indentPadding)
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = indentPadding, vertical = defaultPadding),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = stringResource(R.string.main_section_description),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth(0.6f)
            )
            Image(
                painter = painterResource(id = R.drawable.big_flavour_main_section),
                contentDescription = "Home Hero Screen Image",
                modifier = Modifier.clip(MaterialTheme.shapes.medium)
            )
        }
        Button(
            onClick = {
                Toast.makeText(context, R.string.main_section_order_confirmation, Toast.LENGTH_LONG).show()
            },
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.padding(start = indentPadding)
        ) {
            Text(
                text = stringResource(R.string.main_section_button_order),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@PreviewLightDark
@Composable
fun HomeHeroScreenPreview() {
    BigFlavourTheme {
        HomeHeroScreen()
    }
}
