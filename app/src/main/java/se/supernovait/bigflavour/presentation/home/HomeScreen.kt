package se.supernovait.bigflavour.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme

@Composable
fun HomeScreen(){
    Column {
        HomeHeroScreen()

        Column {
            WeeklySpecial()
        }
    }
}

@PreviewLightDark
@Composable
fun HomeScreenPreview() {
    BigFlavourTheme {
        HomeScreen()
    }
}
