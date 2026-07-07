package se.supernovait.bigflavour.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import se.supernovait.bigflavour.presentation.common.container.ComponentPreviewContainer
import se.supernovait.bigflavour.presentation.home.HomeScreen
import se.supernovait.bigflavour.ui.theme.BigFlavourTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BigFlavourTheme {
                AppScaffold()
            }
        }
    }
}

@Composable
private fun AppScaffold() {
    Scaffold(
        topBar = { AppTopBar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            HomeScreen()
        }
    }
}

@PreviewLightDark
@Composable
fun AppScaffoldPreview() {
    ComponentPreviewContainer {
        AppScaffold()
    }
}