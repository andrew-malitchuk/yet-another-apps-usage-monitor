package dev.yaaum.presentation.core.ui.composable.button.base.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

/**
 * Method to draw button
 *
 * @param text button title; if `null` - title will be hidden
 * @param icon button icon; if `null` - icon will be hidden
 * @param backgroundColor
 * @param foregroundColor
 * @param borderColor
 * @param shape button shape
 * @param iconSize
 * @param borderSize
 * @param spacing space between [icon] and [text]
 * @param minWidth
 * @param minHeight
 * @param paddings
 * @param textStyle
 * @param modifier
 */
@SuppressLint("ComposableNaming")
@Suppress("LongParameterList")
@Composable
fun drawButton(
    text: String?,
    icon: ImageVector?,
    backgroundColor: Color,
    foregroundColor: Color,
    borderColor: Color,
    shape: Shape,
    iconSize: Dp,
    borderSize: Dp,
    spacing: Dp,
    minWidth: Dp,
    minHeight: Dp,
    paddings: PaddingValues,
    textStyle: TextStyle?,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .border(
                width = borderSize,
                color = borderColor,
                shape = shape,
            )
            .background(
                color = backgroundColor,
                shape = shape,
            )
            .padding(paddings)
            .defaultMinSize(minWidth = minWidth, minHeight = minHeight),
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = foregroundColor,
                modifier = Modifier.size(iconSize),
            )
        }
        if (text != null && icon != null) {
            Spacer(modifier = Modifier.width(spacing))
        }

        if (text != null) {
            if (textStyle != null) {
                Text(text = text, color = foregroundColor, style = textStyle)
            } else {
                Text(text = text, color = foregroundColor)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
@Suppress("MagicNumber")
internal fun Preview_drawButton_Dark() {
    YaaumTheme(useDarkTheme = true) {
        drawButton(
            icon = Icons.Default.Home,
            text = "Button",
            backgroundColor = Color.White,
            foregroundColor = Color.Black,
            borderColor = Color.Black,
            shape = RoundedCornerShape(50),
            iconSize = 32.dp,
            borderSize = 3.dp,
            spacing = 8.dp,
            minWidth = 60.dp,
            minHeight = 48.dp,
            paddings = PaddingValues(all = 16.dp),
            textStyle = LocalTextStyle.current.copy(fontSize = 24.sp),
        )
    }
}

@Preview(showBackground = true)
@Composable
@Suppress("MagicNumber")
internal fun Preview_drawButton_Light() {
    YaaumTheme(useDarkTheme = false) {
        drawButton(
            icon = Icons.Default.Home,
            text = "Button",
            backgroundColor = Color.White,
            foregroundColor = Color.Black,
            borderColor = Color.Black,
            shape = RoundedCornerShape(50),
            iconSize = 32.dp,
            borderSize = 3.dp,
            spacing = 8.dp,
            minWidth = 60.dp,
            minHeight = 48.dp,
            paddings = PaddingValues(all = 16.dp),
            textStyle = LocalTextStyle.current.copy(fontSize = 24.sp),
        )
    }
}
