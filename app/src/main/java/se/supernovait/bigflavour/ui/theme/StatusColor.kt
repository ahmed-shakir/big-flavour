package se.supernovait.bigflavour.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

data class StatusColor(
    val success: Color = Color(0xFF00FF00),
    val error: Color = Color(0xFFFF0000),
    val warning: Color = Color(0xFFFFD700),
)

val LocalStatus = compositionLocalOf { StatusColor() }

val MaterialTheme.statusColor: StatusColor
    @Composable
    @ReadOnlyComposable
    get() = LocalStatus.current
