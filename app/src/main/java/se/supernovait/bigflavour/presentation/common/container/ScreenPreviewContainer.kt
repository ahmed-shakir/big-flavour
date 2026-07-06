package se.supernovait.bigflavour.presentation.common.container

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme

@Composable
fun PreviewContainer(content: @Composable () -> Unit) {
    BigFlavourTheme {
        Surface {
            content()
        }
    }
}
