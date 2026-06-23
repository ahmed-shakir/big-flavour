package se.supernovait.bigflavour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme
import se.supernovait.bigflavour.ui.theme.spacing

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BigFlavourTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        MainSection()
                    }
                }
            }
        }
    }
}

@Composable
fun MainSection() {
    val defaultPadding = MaterialTheme.spacing.paddingMedium

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.main_section_title),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = defaultPadding, top = defaultPadding)
        )
        Text(
            text = stringResource(R.string.main_section_location),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(start = defaultPadding)
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(defaultPadding),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.big_flavour_main_section),
                contentDescription = "",
                modifier = Modifier.height(100.dp)
            )
        }
        Button(
            onClick = {},
            shape = MaterialTheme.shapes.extraSmall,
            modifier = Modifier.padding(horizontal = defaultPadding)
        ) {
            Text(text = stringResource(R.string.main_section_button_order))
        }
    }
}

@PreviewLightDark
@Composable
fun GreetingPreview() {
    BigFlavourTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Column(Modifier.padding(it)) {
                MainSection()
            }
        }
    }
}
