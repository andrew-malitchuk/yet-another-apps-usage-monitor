package dev.yaaum.presentation.core.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.theme.common.YaaumTypography

val typography = YaaumTypography(
    display = TextStyle(
        fontSize = fontSize.display,
        lineHeight = lineHeight.display,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(
            Font(
                R.font.roboto_black,
                weight = FontWeight.Black,
                style = FontStyle.Normal,
            ),
        ),
    ),
    headline = TextStyle(
        fontSize = fontSize.headline,
        lineHeight = lineHeight.headline,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(
            Font(
                R.font.roboto_black,
                weight = FontWeight.Black,
                style = FontStyle.Normal,
            ),
        ),
    ),
    title = TextStyle(
        fontSize = fontSize.title,
        lineHeight = lineHeight.title,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(
            Font(
                R.font.roboto_black,
                weight = FontWeight.Black,
                style = FontStyle.Normal,
            ),
        ),
    ),
    subHeading = TextStyle(
        fontSize = fontSize.subHeading,
        lineHeight = lineHeight.subHeading,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(
            Font(
                R.font.roboto_black,
                weight = FontWeight.Black,
                style = FontStyle.Normal,
            ),
        ),
    ),
    body = TextStyle(
        fontSize = fontSize.body,
        lineHeight = lineHeight.body,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(
            Font(
                R.font.roboto_black,
                weight = FontWeight.Black,
                style = FontStyle.Normal,
            ),
        ),
    ),
    caption = TextStyle(
        fontSize = fontSize.caption,
        lineHeight = lineHeight.caption,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(
            Font(
                R.font.roboto_black,
                weight = FontWeight.Black,
                style = FontStyle.Normal,
            ),
        ),
    ),
    button = TextStyle(
        fontSize = fontSize.button,
        lineHeight = lineHeight.button,
        fontFamily = FontFamily(
            Font(
                R.font.ubuntu_bold,
                weight = FontWeight.Black,
                style = FontStyle.Normal,
            ),
        ),
    ),
)
