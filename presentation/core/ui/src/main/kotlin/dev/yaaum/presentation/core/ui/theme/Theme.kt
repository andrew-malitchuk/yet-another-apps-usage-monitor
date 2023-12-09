package dev.yaaum.presentation.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.yaaum.presentation.core.models.ThemeUiModel
import dev.yaaum.presentation.core.ui.theme.ext.toYaaumColors

@Composable
@Suppress("FunctionNaming", "unused", "OptionalWhenBraces")
fun YaaumTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    theme: ThemeUiModel? = null,
    content: @Composable () -> Unit,
) {
    //region TODO: recode
    val systemUiController = rememberSystemUiController()
    val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val colorScheme = when {
        dynamicColor && useDarkTheme -> {
            dynamicDarkColorScheme(LocalContext.current)
        }

        dynamicColor && !useDarkTheme -> {
            dynamicLightColorScheme(LocalContext.current)
        }

        else -> {
            null
        }
    }
    colorScheme?.toYaaumColors() ?: baseDarkColorPalette
    val colors = when (theme) {
        ThemeUiModel.DARK -> baseDarkColorPalette
        ThemeUiModel.LIGHT -> baseLightColorPalette
        ThemeUiModel.DYNAMIC -> colorScheme?.toYaaumColors() ?: baseDarkColorPalette
        else -> if (isSystemInDarkTheme()) {
            baseDarkColorPalette
        } else {
            baseLightColorPalette
        }
    }
    //endregion TODO: recode

    CompositionLocalProvider(
        LocalYaaumColors provides colors,
        LocalYaaumCorners provides corners,
        LocalYaaumDividers provides dividers,
        LocalYaaumShape provides shapes,
        LocalYaaumSpacing provides spacing,
        LocalYaaumTypography provides typography,
        LocalYaaumFontSize provides fontSize,
        LocalYaaumIcons provides icons,
        content = content,
    )

    with(systemUiController) {
        setSystemBarsColor(
            color = colors.background,
        )
        setNavigationBarColor(
            color = colors.background,
        )
    }
}
