package se.supernovait.bigflavour.presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.presentation.common.container.ScreenPreviewContainer

@Composable
fun SettingsScreen(){
    Column {
        Text(text = "Settings")
    }
}

@PreviewLightDark
@Composable
fun SettingsScreenPreview() {
    ScreenPreviewContainer {
        SettingsScreen()
    }
}
