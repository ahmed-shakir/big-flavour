package se.supernovait.bigflavour.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Espresso,
    onPrimary = Color.White,

    primaryContainer = Color(0xFF6B4A39),
    onPrimaryContainer = Color.White,

    secondary = CaramelGold,
    onSecondary = CoffeeBlack,

    secondaryContainer = Color(0xFFF6E2B9),
    onSecondaryContainer = CoffeeBlack,

    tertiary = BerryPink,
    onTertiary = Color.White,

    tertiaryContainer = Color(0xFFF6D6DF),
    onTertiaryContainer = CoffeeBlack,

    background = WarmWhite,
    onBackground = CoffeeBlack,

    surface = Latte,
    onSurface = CoffeeBlack,

    surfaceDim = Color(0xFFEDE5DC),
    surfaceBright = Color(0xFFFFFCF9),

    surfaceContainerLowest = Color.White,
    surfaceContainerLow = Color(0xFFFBF6F1),
    surfaceContainer = Latte,
    surfaceContainerHigh = Color(0xFFF0E8DF),
    surfaceContainerHighest = Color(0xFFE9DFD7),

    surfaceVariant = Color(0xFFE9DFD7),
    onSurfaceVariant = CoffeeGray,

    outline = Color(0xFFB7A9A0),

    error = Color(0xFFBA1A1A),
    onError = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = HoneyGold,
    onPrimary = DarkRoast,

    primaryContainer = Espresso,
    onPrimaryContainer = WarmWhite,

    secondary = CaramelGold,
    onSecondary = CoffeeBlack,

    secondaryContainer = Color(0xFF6D5322),
    onSecondaryContainer = WarmWhite,

    tertiary = BerryPink,
    onTertiary = Color.White,

    tertiaryContainer = Color(0xFF7A3A4D),
    onTertiaryContainer = WarmWhite,

    background = Color(0xFF16100D),
    onBackground = WarmWhite,

    surface = Color(0xFF1D1613),
    onSurface = WarmWhite,

    surfaceDim = Color(0xFF17110E),
    surfaceBright = Color(0xFF322722),

    surfaceContainerLowest = Color(0xFF120D0B),
    surfaceContainerLow = Color(0xFF1A1411),
    surfaceContainer = Color(0xFF231B17),
    surfaceContainerHigh = Color(0xFF2B221E),
    surfaceContainerHighest = Color(0xFF352B26),

    surfaceVariant = Color(0xFF3A2E28),
    onSurfaceVariant = Color(0xFFD8C5BB),

    outline = Color(0xFF8B7B73),

    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005)
)

@Composable
fun BigFlavourTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        // Dynamic color is available on Android 12+
        /*dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }*/

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
