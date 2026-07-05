package se.supernovait.bigflavour.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.domain.model.DishMenuItemData
import se.supernovait.bigflavour.presentation.common.DishMenu
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme

@Composable
fun HomeScreen(){
    Column {
        HomeHeroScreen()

        Column {
            WeeklySpecial()
            DishMenu(
                items = listOf(
                    DishMenuItemData(
                        title = "Greek Salad",
                        body = "The famous greek salad of crispy lettuce, peppers, olives, tomato and our Dubai chicken.",
                        price = 12.99f,
                        imageResourceId = R.drawable.menu_item_greek_salad,
                        imageDescription = "Greek Salad Image"
                    )
                )
            )
        }
    }
}

@PreviewLightDark
@Composable
fun HomeScreenPreview() {
    BigFlavourTheme {
        Scaffold {
            Column(Modifier.padding(it)) {
                HomeScreen()
            }
        }
    }
}
