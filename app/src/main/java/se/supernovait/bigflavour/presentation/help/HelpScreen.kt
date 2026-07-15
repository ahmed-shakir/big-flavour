package se.supernovait.bigflavour.presentation.help

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.presentation.common.container.ScreenPreviewContainer

@Composable
fun HelpScreen(){
    Column {
        Text(text = "Help center")
    }
}

@PreviewLightDark
@Composable
private fun HelpScreenPreview() {
    ScreenPreviewContainer {
        HelpScreen()
    }
}
