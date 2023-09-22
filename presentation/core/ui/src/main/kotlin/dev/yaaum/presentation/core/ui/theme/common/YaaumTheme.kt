package dev.yaaum.presentation.core.ui.theme.common

import androidx.compose.runtime.Composable
import dev.yaaum.presentation.core.ui.theme.LocalYaaumColors
import dev.yaaum.presentation.core.ui.theme.LocalYaaumCorners
import dev.yaaum.presentation.core.ui.theme.LocalYaaumDividers
import dev.yaaum.presentation.core.ui.theme.LocalYaaumFontSize
import dev.yaaum.presentation.core.ui.theme.LocalYaaumLineHeight
import dev.yaaum.presentation.core.ui.theme.LocalYaaumShape
import dev.yaaum.presentation.core.ui.theme.LocalYaaumSpacing
import dev.yaaum.presentation.core.ui.theme.LocalYaaumTypography

/**
 * Theme configure object
 */
@Suppress("unused")
object YaaumTheme {
    val colors: YaaumColors
        @Composable
        get() = LocalYaaumColors.current
    val corners: YaaumCorners
        @Composable
        get() = LocalYaaumCorners.current
    val dividers: YaaumDividers
        @Composable
        get() = LocalYaaumDividers.current
    val fontSize: YaaumFontSize
        @Composable
        get() = LocalYaaumFontSize.current
    val lineHeight: YaaumLineHeight
        @Composable
        get() = LocalYaaumLineHeight.current
    val shapes: YaaumShape
        @Composable
        get() = LocalYaaumShape.current
    val spacing: YaaumSpacing
        @Composable
        get() = LocalYaaumSpacing.current
    val typography: YaaumTypography
        @Composable
        get() = LocalYaaumTypography.current
}
