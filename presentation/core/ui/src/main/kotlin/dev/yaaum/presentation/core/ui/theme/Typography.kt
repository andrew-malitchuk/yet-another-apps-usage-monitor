package dev.yaaum.presentation.core.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import dev.yaaum.presentation.core.ui.theme.common.YaaumTypography

val typography = YaaumTypography(
    display = TextStyle(
        fontSize = fontSize.display,
        lineHeight = lineHeight.display,
        fontWeight = FontWeight.Normal,
    ),
    headline = TextStyle(
        fontSize = fontSize.headline,
        lineHeight = lineHeight.headline,
        fontWeight = FontWeight.Normal,
    ),
    title = TextStyle(
        fontSize = fontSize.title,
        lineHeight = lineHeight.title,
        fontWeight = FontWeight.Medium,
    ),
    subHeading = TextStyle(
        fontSize = fontSize.subHeading,
        lineHeight = lineHeight.subHeading,
        fontWeight = FontWeight.Normal,
    ),
    body = TextStyle(
        fontSize = fontSize.body,
        lineHeight = lineHeight.body,
        fontWeight = FontWeight.Normal,
    ),
    caption = TextStyle(
        fontSize = fontSize.caption,
        lineHeight = lineHeight.caption,
        fontWeight = FontWeight.Normal,
    ),
    button = TextStyle(
        fontSize = fontSize.button,
        lineHeight = lineHeight.button,
        fontWeight = FontWeight.Medium,
    ),
)
