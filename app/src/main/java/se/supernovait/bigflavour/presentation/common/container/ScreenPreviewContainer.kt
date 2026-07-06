package se.supernovait.bigflavour.presentation.common.container

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme

@Composable
fun ScreenPreviewContainer(content: @Composable () -> Unit) {
    BigFlavourTheme {
        Scaffold {
            Column(Modifier.padding(it)) {
                content()
            }
        }
    }
}
