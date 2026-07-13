package se.supernovait.bigflavour.presentation.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun SectionHeader(text: String) {
    Card(shape = MaterialTheme.shapes.extraSmall, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(MaterialTheme.spacing.small)
        )
    }
}

@PreviewLightDark
@Composable
fun WeeklySpecialPreview() {
    ComponentPreviewContainer {
        SectionHeader(text = "Section Header")
    }
}
