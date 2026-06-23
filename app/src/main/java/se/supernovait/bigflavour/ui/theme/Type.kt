package se.supernovait.bigflavour.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import se.supernovait.bigflavour.R

val Inter = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold)
)

val PlayfairDisplay = FontFamily(
    Font(R.font.playfair_display_regular, FontWeight.Normal),
    Font(R.font.playfair_display_semibold, FontWeight.SemiBold),
    Font(R.font.playfair_display_bold, FontWeight.Bold)
)

val Typography = Typography().run {
    copy(
        displayLarge = displayLarge.copy(fontFamily = PlayfairDisplay),
        displayMedium = displayMedium.copy(fontFamily = PlayfairDisplay),
        displaySmall = displaySmall.copy(fontFamily = PlayfairDisplay),
        headlineLarge = headlineLarge.copy(fontFamily = PlayfairDisplay),
        headlineMedium = headlineMedium.copy(fontFamily = PlayfairDisplay),
        headlineSmall = headlineSmall.copy(fontFamily = PlayfairDisplay),
        titleLarge = titleLarge.copy(fontFamily = Inter),
        titleMedium = titleMedium.copy(fontFamily = Inter),
        titleSmall = titleSmall.copy(fontFamily = Inter),
        bodyLarge = bodyLarge.copy(fontFamily = Inter),
        bodyMedium = bodyMedium.copy(fontFamily = Inter),
        bodySmall = bodySmall.copy(fontFamily = Inter),
        labelLarge = labelLarge.copy(fontFamily = Inter),
        labelMedium = labelMedium.copy(fontFamily = Inter),
        labelSmall = labelSmall.copy(fontFamily = Inter)
    )
}
