package dev.yaaum.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
@Suppress("FunctionNaming", "unused")
fun YaaumTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()

    val colors = if (useDarkTheme) {
        baseDarkColorPalette
    } else {
        baseLightColorPalette
    }

    with(systemUiController) {
        setSystemBarsColor(
            color = colors.background,
        )
        setNavigationBarColor(
            color = colors.background,
        )
    }

    CompositionLocalProvider(
        LocalYaaumColors provides colors,
        LocalYaaumCorners provides corners,
        LocalYaaumDividers provides dividers,
        LocalYaaumShape provides shapes,
        LocalYaaumSpacing provides spacing,
        LocalYaaumTypography provides typography,
        content = content,
    )
}
