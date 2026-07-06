package se.supernovait.bigflavour.presentation.common.dish_menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun DishMenuItem(title: String, body: String, price: Float, imageResourceId: Int, imageDescription: String = "") {
    Card(shape = MaterialTheme.shapes.extraSmall, modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.small)
        ) {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = body,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.spacing.extraSmall)
                        .fillMaxWidth(.75f)
                )
                Text(
                    text = "AED $price",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(painter = painterResource(id = imageResourceId), contentDescription = imageDescription)
        }
        CartItemCounter() { }
    }
}

@Composable
fun CartItemCounter(count: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(MaterialTheme.spacing.extraSmall)
    ) {
        if (count > 0) {
            // TODO: show +, count & -, increment/decrement on click
        } else {
            // TODO: show cart icon and add 1 on click
        }
    }
}

@PreviewLightDark
@Composable
fun DishMenuItemPreview() {
    BigFlavourTheme {
        DishMenuItem(
            title = "Test Dish",
            body = "Very yummy",
            price = 9.95f,
            imageResourceId = R.drawable.menu_item_greek_salad
        )
    }
}
