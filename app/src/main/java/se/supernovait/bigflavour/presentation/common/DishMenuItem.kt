package se.supernovait.bigflavour.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme
import se.supernovait.bigflavour.ui.theme.spacing

@Composable
fun MenuItem() {
    Card {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
        ) {
            Column {
                Text(
                    text = "Greek Salad",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "The famous greek salad of crispy lettuce, peppers, olives, tomato and our Dubai chicken.",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.spacing.extraSmall)
                        .fillMaxWidth(.75f)
                )
                Text(
                    text = "AED 12.99",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(id = R.drawable.menu_item_greek_salad),
                    contentDescription = "Greek Salad Image"
                )
            }
        }
    }
    HorizontalDivider(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small),
        color = Color.LightGray,
        thickness = MaterialTheme.spacing.divider
    )


    // TODO
    //Step 4: Define a card for a dish in the menu
    //Inside the empty MenuDish() composable, define a Card.
    //Inside the card, add a Row. The Row should cover the full width. Apply a padding of 8 dp to it.
    //Inside the Row, add a Column and an Image.
    //Inside the Column, define the following 3 Text composables:
    //1.	The first text should be "Greek Salad", font size 18 and bold.
    //2.	The second text should be "The famous Greek salad of crispy lettuce, peppers, olives, our Chicago ...". Set the color to gray. Set the top and bottom padding to 5 dp. Set max width to .75f.
    //3.	The third text should be "$12.99". Set the color to gray and bold the font.
    //
    //For the Image composable, load the image from the drawable using painterResource(). Set the content description to "Greek Salad Image".
}

@PreviewLightDark
@Composable
fun MenuItemPreview() {
    BigFlavourTheme {
        MenuItem()
    }
}
