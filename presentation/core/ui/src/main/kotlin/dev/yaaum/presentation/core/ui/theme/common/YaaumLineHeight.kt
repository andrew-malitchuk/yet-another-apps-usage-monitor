package dev.yaaum.presentation.core.ui.theme.common

import androidx.compose.ui.unit.TextUnit

/**
 * Convention about available font line height
 */
data class YaaumLineHeight(
    val display: TextUnit,
    val headline: TextUnit,
    val title: TextUnit,
    val subHeading: TextUnit,
    val body: TextUnit,
    val caption: TextUnit,
    val button: TextUnit,
)
